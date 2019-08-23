package com.jk.model;

import java.io.Serializable;

public class Payment implements Serializable {

private Integer commId;//商品id

private String commImg;//商品图片

private String commName;//商品名称

private Double commPrice;//商品价格

private double zPrice;  //商品总价价格

    public double getzPrice() {
        return zPrice;
    }

    public void setzPrice(double zPrice) {
        this.zPrice = zPrice;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommImg() {
        return commImg;
    }

    public void setCommImg(String commImg) {
        this.commImg = commImg;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Double getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(Double commPrice) {
        this.commPrice = commPrice;
    }
}