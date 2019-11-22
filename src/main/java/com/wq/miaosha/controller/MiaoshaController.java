package com.wq.miaosha.controller;


import com.wq.miaosha.entity.MiaoShaOrder;
import com.wq.miaosha.entity.OrderInfo;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.redis.RedisService;
import com.wq.miaosha.result.CodeMsg;
import com.wq.miaosha.result.Result;
import com.wq.miaosha.service.GoodsService;
import com.wq.miaosha.service.MiaoShaOrderService;
import com.wq.miaosha.service.MiaoshaService;
import com.wq.miaosha.service.UserService;
import com.wq.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

	@Autowired
	UserService userService;
	
	@Autowired
	RedisService redisService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	MiaoShaOrderService miaoShaOrderService;
	
	@Autowired
	MiaoshaService miaoshaService;
	
	/**
	 * QPS:1306
	 * 5000 * 10
	 * */
	/**
	 *  GET POST有什么区别？
	 * */
	@RequestMapping(value="/do_miaosha", method=RequestMethod.POST)
	@ResponseBody
	public Result<OrderInfo> miaosha(Model model,User user,
									 @RequestParam("goodsId")long goodsId) {
		model.addAttribute("user", user);
		if(user == null) {
			return Result.error(CodeMsg.SESSION_ERROR);
		}
		//判断库存
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);//10个商品，req1 req2
		int stock = goods.getStockCount();
		if(stock <= 0) {
			return Result.error(CodeMsg.MIAO_SHA_OVER);
		}
		//判断是否已经秒杀到了
		MiaoShaOrder order = miaoShaOrderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
		if(order != null) {
			return Result.error(CodeMsg.REPEATE_MIAOSHA);
		}
		//减库存 下订单 写入秒杀订单
		OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
		return Result.success(orderInfo);
	}
}
