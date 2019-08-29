/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoShop
 * Author:   李辉
 * Date:     2019/8/21 15:43
 * Description: 购物车
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈购物车〉
 *
 * @author 李辉
 * @create 2019/8/21
 * @since 1.0.0
 */
public class GoShop  implements Serializable {
    private  String  id;
    private  Integer  userId;
    private  Integer  goodsId;
    private  String  goodsImg;
    private  String  goodsName;
    private  String  goodsInfo;
    private  Integer  weight;
    private  Double  goodsPrice;
    private  Double  preferentialMoney;
    private  Double  realityMoney;
    private Integer goodsNumber;//购买数量
    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getPreferentialMoney() {
        return preferentialMoney;
    }

    public void setPreferentialMoney(Double preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }

    public Double getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(Double realityMoney) {
        this.realityMoney = realityMoney;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGoodsId(Integer goodsId) {
        return this.goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }
}