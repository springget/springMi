/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Refund
 * Author:   李辉
 * Date:     2019/8/15 15:08
 * Description: 退款表
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈退款表〉
 *
 * @author 李辉
 * @create 2019/8/15
 * @since 1.0.0
 */
public class Refund   implements Serializable {
   private Integer refundId;//退款id
   private Integer orderId;//订单id
   private Integer goodsId;//商品id   取商品内容
   private Integer refundMoney;//退款金额
   private Integer sendStatus;//发货状态 1 已发货  2未发货
   private Integer refundStatus;//退款方式  1仅退款 2退货退款

   private Integer refundInfo;//退款内容 （原因）
   // 1 不喜欢/不想要  2未按约定时间发货 3包装/商品破损 4快递/物流无跟踪记录 5退运费  6货物破损已拒签 7快递/物流一直未送到
   private Integer refundrecord; //1 退款成功   2 已拒绝退款  3退款待处理（默认）  4待买家发货  5退款关闭
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date refundTime;//申请时间

   //临时
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date startdate;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date enddate;
   private String goodsName; //商品名称
   private Double realityMoney;//实支付

   public Integer getRefundId() {
      return refundId;
   }

   public void setRefundId(Integer refundId) {
      this.refundId = refundId;
   }

   public Integer getRefundMoney() {
      return refundMoney;
   }

   public void setRefundMoney(Integer refundMoney) {
      this.refundMoney = refundMoney;
   }

   public Integer getSendStatus() {
      return sendStatus;
   }

   public void setSendStatus(Integer sendStatus) {
      this.sendStatus = sendStatus;
   }

   public Integer getRefundStatus() {
      return refundStatus;
   }

   public void setRefundStatus(Integer refundStatus) {
      this.refundStatus = refundStatus;
   }

   public Date getRefundTime() {
      return refundTime;
   }

   public void setRefundTime(Date refundTime) {
      this.refundTime = refundTime;
   }

   public Date getStartdate() {
      return startdate;
   }

   public void setStartdate(Date startdate) {
      this.startdate = startdate;
   }

   public Date getEnddate() {
      return enddate;
   }

   public void setEnddate(Date enddate) {
      this.enddate = enddate;
   }

   public String getGoodsName() {
      return goodsName;
   }

   public void setGoodsName(String goodsName) {
      this.goodsName = goodsName;
   }

   public Double getRealityMoney() {
      return realityMoney;
   }

   public void setRealityMoney(Double realityMoney) {
      this.realityMoney = realityMoney;
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

   public Integer getRefundInfo() {
      return refundInfo;
   }

   public void setRefundInfo(Integer refundInfo) {
      this.refundInfo = refundInfo;
   }

   public Integer getRefundrecord() {
      return refundrecord;
   }

   public void setRefundrecord(Integer refundrecord) {
      this.refundrecord = refundrecord;
   }
}