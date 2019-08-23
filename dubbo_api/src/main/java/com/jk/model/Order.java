package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

public class Order   implements Serializable {

    private Integer orderId; //订单表

    private Integer goodsId;  //关联商品表

    private Double goodsPrice; //商品金额

    private Integer orderNumber;//购买数量

    private Double orderMoney;//总金额

    private Double realityMoney;//实支付

    private Integer logisticId;//物流id

    private Double  preferentialMoney;//优惠

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;//订单时间

//临时
    private String goodsName; //商品名称

    private String goodsImg;//商品图片

    private Double fastMoney;//快递费

    private Integer userId;//用户Id

    private Integer orderStatus;//交易状态 0 全部  1 待支付 2 代发货 3 已发货 4已完成 5已关闭 6退款中

    private String userName;//用户姓名

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getFastMoney() {
        return fastMoney;
    }

    public void setFastMoney(Double fastMoney) {
        this.fastMoney = fastMoney;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(Double realityMoney) {
        this.realityMoney = realityMoney;
    }

    public Integer getLogisticId() {
        return logisticId;
    }

    public void setLogisticId(Integer logisticId) {
        this.logisticId = logisticId;
    }

    public Double getPreferentialMoney() {
        return preferentialMoney;
    }

    public void setPreferentialMoney(Double preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }
}
