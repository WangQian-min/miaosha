package com.wq.miaosha.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.goods_Title
     *
     * @mbg.generated
     */
    private String goodsTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.goods_Img
     *
     * @mbg.generated
     */
    private String goodsImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.goods_Detail
     *
     * @mbg.generated
     */
    private String goodsDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.good_Price
     *
     * @mbg.generated
     */
    private Double goodPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Goods.goods_Stock
     *
     * @mbg.generated
     */
    private Integer goodsStock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Goods
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.id
     *
     * @return the value of Goods.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.id
     *
     * @param id the value for Goods.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.goods_name
     *
     * @return the value of Goods.goods_name
     *
     * @mbg.generated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.goods_name
     *
     * @param goodsName the value for Goods.goods_name
     *
     * @mbg.generated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.goods_Title
     *
     * @return the value of Goods.goods_Title
     *
     * @mbg.generated
     */
    public String getGoodsTitle() {
        return goodsTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.goods_Title
     *
     * @param goodsTitle the value for Goods.goods_Title
     *
     * @mbg.generated
     */
    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.goods_Img
     *
     * @return the value of Goods.goods_Img
     *
     * @mbg.generated
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.goods_Img
     *
     * @param goodsImg the value for Goods.goods_Img
     *
     * @mbg.generated
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.goods_Detail
     *
     * @return the value of Goods.goods_Detail
     *
     * @mbg.generated
     */
    public String getGoodsDetail() {
        return goodsDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.goods_Detail
     *
     * @param goodsDetail the value for Goods.goods_Detail
     *
     * @mbg.generated
     */
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.good_Price
     *
     * @return the value of Goods.good_Price
     *
     * @mbg.generated
     */
    public Double getGoodPrice() {
        return goodPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.good_Price
     *
     * @param goodPrice the value for Goods.good_Price
     *
     * @mbg.generated
     */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Goods.goods_Stock
     *
     * @return the value of Goods.goods_Stock
     *
     * @mbg.generated
     */
    public Integer getGoodsStock() {
        return goodsStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Goods.goods_Stock
     *
     * @param goodsStock the value for Goods.goods_Stock
     *
     * @mbg.generated
     */
    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Goods
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsTitle=").append(goodsTitle);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", goodsDetail=").append(goodsDetail);
        sb.append(", goodPrice=").append(goodPrice);
        sb.append(", goodsStock=").append(goodsStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}