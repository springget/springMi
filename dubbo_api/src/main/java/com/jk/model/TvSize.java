package com.jk.model;

import java.io.Serializable;

public class TvSize implements Serializable {

    private Integer sid;

    private Double size;

    private Double size2;

    public Double getSize2() {
        return size2;
    }

    public void setSize2(Double size2) {
        this.size2 = size2;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

}
