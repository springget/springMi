package com.jk.model;



import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable {
    private Integer shopId;//店铺Id
    private String shopName; //店铺名称
    private String shopLogo;//店铺logo
    private String shopPhone;//店铺联系方式
    private String shopUrl;//店铺地址
    private String shopIntro;//店铺简介
    private String shopThearea;//店铺详情地址

    public String getShopThearea() {
        return shopThearea;
    }

    public void setShopThearea(String shopThearea) {
        this.shopThearea = shopThearea;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopIntro() {
        return shopIntro;
    }

    public void setShopIntro(String shopIntro) {
        this.shopIntro = shopIntro;
    }
}