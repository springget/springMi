package com.jk.model;

import java.io.Serializable;

public class TvxiantQing implements Serializable {

       private Integer tid;

       private Double size; //电视尺寸

       private String versions;//版本

       private String ram; //内存+运存

       private String info; //简介

       private String color; //颜色

       private String televName;

       private String televImg;

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

    public Integer getTid() {
            return tid;
        }

        public void setTid(Integer tid) {
            this.tid = tid;
        }

        public Double getSize() {
            return size;
        }

        public void setSize(Double size) {
            this.size = size;
        }

        public String getVersions() {
            return versions;
        }

        public void setVersions(String versions) {
            this.versions = versions;
        }

        public String getRam() {
            return ram;
        }

        public void setRam(String ram) {
            this.ram = ram;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
}
