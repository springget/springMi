package com.jk.model;

import java.io.Serializable;

public class Member implements Serializable {

    private Integer memberId;  //会员
    private Integer memberName; //会员  0 普通 1 初级 2 中级 3 高级
/*    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private String memberDate;   //购买时间
/*    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private String memberTime;   //过期时间
    private double memberPrice;   //会员价格

    private String userName;//用户姓名    关联User表字段
    private String userPhone;//用户手机号   关联User表字段
    private String img;//头像 关联User表字段

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberName() {
        return memberName;
    }

    public void setMemberName(Integer memberName) {
        this.memberName = memberName;
    }

    public String getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(String memberDate) {
        this.memberDate = memberDate;
    }

    public String getMemberTime() {
        return memberTime;
    }

    public void setMemberTime(String memberTime) {
        this.memberTime = memberTime;
    }

    public double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(double memberPrice) {
        this.memberPrice = memberPrice;
    }
}
