package com.wq.miaosha.service.impl;

import com.wq.miaosha.entity.OrderInfo;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.service.GoodsService;
import com.wq.miaosha.service.MiaoShaOrderService;
import com.wq.miaosha.service.MiaoshaService;
import com.wq.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <一句话功能简述>
 *
 * @author qianwang13(qianwang13 @ iflytek.com)
 * @Datetime 2019/11/15 09:46
 * @Copyright (c) 2019 科大讯飞股份有限公司. All rights reserved.
 * @since [产品/模块版本]
 */
@Service
public class MiaoshaServiceImpl implements MiaoshaService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    MiaoShaOrderService miaoShaOrderService;
    @Transactional
    public OrderInfo miaosha(User user, GoodsVo goods) {
        //减库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);
        //order_info maiosha_order
        return miaoShaOrderService.createOrder(user, goods);
    }
}
