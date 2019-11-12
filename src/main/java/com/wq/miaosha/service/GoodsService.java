package com.wq.miaosha.service;

import com.wq.miaosha.vo.GoodsVo;

import java.util.List;

public interface GoodsService {
    public List<GoodsVo> listGoodsVo();

    public GoodsVo getGoodsVoByGoodsId(long goodsId);
}
