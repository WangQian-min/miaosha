package com.wq.miaosha.mapper;

import com.wq.miaosha.entity.MiaoShaOrder;
import org.apache.ibatis.annotations.Param;

public interface MiaoShaOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    int insert(MiaoShaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    int insertSelective(MiaoShaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    MiaoShaOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MiaoShaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaoshaorder
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MiaoShaOrder record);

     MiaoShaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userId")long userId, @Param("goodsId")long goodsId);
}