package com.jk.model;

import java.io.Serializable;

public class Television implements Serializable {

    private Integer televId;//商品Id
    private String televName; //商品名称
    private String televImg;//商品图片
    private String televsize;  //尺寸
    private String  televInfo;//商品描述
    private Integer parameterId;//类型 id

    private Integer tvPrice;

    private Double size;

    private String version;

    private String version2;

    private Double size2;

    public Integer getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(Integer tvPrice) {
        this.tvPrice = tvPrice;
    }

    public Double getSize2() {
        return size2;
    }

    public void setSize2(Double size2) {
        this.size2 = size2;
    }

    public String getVersion2() {
        return version2;
    }

    public void setVersion2(String version2) {
        this.version2 = version2;
    }


    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getTelevId() {
        return televId;
    }

    public void setTelevId(Integer televId) {
        this.televId = televId;
    }

    public String getTelevName() {
        return televName;
    }

    public void setTelevName(String televName) {
        this.televName = televName;
    }

    public String getTelevImg() {
        return televImg;
    }

    public void setTelevImg(String televImg) {
        this.televImg = televImg;
    }

    public String getTelevsize() {
        return televsize;
    }

    public void setTelevsize(String televsize) {
        this.televsize = televsize;
    }

    public String getTelevInfo() {
        return televInfo;
    }

    public void setTelevInfo(String televInfo) {
        this.televInfo = televInfo;
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }
}
