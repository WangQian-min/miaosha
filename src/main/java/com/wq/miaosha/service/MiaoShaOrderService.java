package com.wq.miaosha.service;

import com.wq.miaosha.entity.MiaoShaOrder;
import com.wq.miaosha.entity.OrderInfo;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.vo.GoodsVo;

/**
 * <一句话功能简述>
 *
 * @author qianwang13(qianwang13 @ iflytek.com)
 * @Datetime 2019/11/14 17:50
 * @Copyright (c) 2019 科大讯飞股份有限公司. All rights reserved.
 * @since [产品/模块版本]
 */
public interface MiaoShaOrderService {
    public MiaoShaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId);
    OrderInfo createOrder(User user, GoodsVo goods);
    OrderInfo getOrderById(long orderId);
}
