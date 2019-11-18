package com.wq.miaosha.service.impl;


import com.wq.miaosha.entity.MiaoShaOrder;
import com.wq.miaosha.entity.OrderInfo;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.mapper.MiaoShaOrderMapper;
import com.wq.miaosha.mapper.OrderInfoMapper;
import com.wq.miaosha.redis.RedisService;
import com.wq.miaosha.service.MiaoShaOrderService;
import com.wq.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MiaoShaOrderServiceImpl implements MiaoShaOrderService {
	
	@Autowired
	MiaoShaOrderMapper miaoShaOrderMapper;

	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	@Autowired
	RedisService redisService;
	
	public MiaoShaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
		return miaoShaOrderMapper.getMiaoshaOrderByUserIdGoodsId(userId, goodsId);

	}

	@Transactional
	public OrderInfo createOrder(User user, GoodsVo goods) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCreateDate(new Date());
		orderInfo.setDeliveryAddrId(0L);
		orderInfo.setGoodsCount(1);
		orderInfo.setGoodsId(goods.getId());
		orderInfo.setGoodsName(goods.getGoodsName());
		orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
		orderInfo.setStatus(0);
		orderInfo.setUserId(user.getId());
		long orderId = orderInfoMapper.insert(orderInfo);
		MiaoShaOrder miaoshaOrder = new MiaoShaOrder();
		miaoshaOrder.setGoodsId(goods.getId());
		miaoshaOrder.setOrderId(orderId);
		miaoshaOrder.setUserId(user.getId());
		miaoShaOrderMapper.insert(miaoshaOrder);
		return orderInfo;
	}
	



}
