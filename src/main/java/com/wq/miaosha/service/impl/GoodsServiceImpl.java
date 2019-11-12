package com.wq.miaosha.service.impl;

import java.util.List;

import com.wq.miaosha.mapper.GoodsMapper;
import com.wq.miaosha.service.GoodsService;
import com.wq.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;

	public List<GoodsVo> listGoodsVo() {
		return goodsMapper.listGoodsVo();
	}

	public GoodsVo getGoodsVoByGoodsId(long goodsId) {

		return goodsMapper.getGoodsVoByGoodsId(goodsId);
	}
}


	
	
	

