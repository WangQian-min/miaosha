package com.wq.miaosha.service;

import com.wq.miaosha.entity.OrderInfo;
import com.wq.miaosha.entity.User;
import com.wq.miaosha.vo.GoodsVo;

/**
 * <一句话功能简述>
 *
 * @author qianwang13(qianwang13 @ iflytek.com)
 * @Datetime 2019/11/15 09:45
 * @Copyright (c) 2019 科大讯飞股份有限公司. All rights reserved.
 * @since [产品/模块版本]
 */
public interface MiaoshaService {
    public OrderInfo miaosha(User user, GoodsVo goods);
}
