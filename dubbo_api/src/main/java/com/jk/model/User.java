/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   李辉
 * Date:     2019/8/15 14:55
 * Description: 用户表
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
 * 〈用户表〉
 *
 * @author 李辉
 * @create 2019/8/15
 * @since 1.0.0
 */
public class User   implements Serializable {
    private Integer userId;//用户Id
    private String userName;//用户姓名
    private String userAccount;//用户账号
    private String userPassword;//用户密码
    private Integer bankId;//银行卡Id
    private Integer memberId;//会员Id
    private Integer commentId;//评论id
    private Integer goodsId;//商品id
    private Integer userPhone;//用户手机号
    private String address;//地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date longinTime;//登陆时间
    private String consignee;//收货人
    private String petName;//昵称
    private Integer integral;//积分
    private Integer logisticId;//物流id
    private String img;//头像
    private Integer memberName;  //关联member 查询会员表



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMemberName() {
        return memberName;
    }

    public void setMemberName(Integer memberName) {
        this.memberName = memberName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLonginTime() {
        return longinTime;
    }

    public void setLonginTime(Date longinTime) {
        this.longinTime = longinTime;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getLogisticId() {
        return logisticId;
    }

    public void setLogisticId(Integer logisticId) {
        this.logisticId = logisticId;
    }
}