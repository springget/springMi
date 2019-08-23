package com.jk.model;

import java.io.Serializable;

public class Pcolor implements Serializable {

    private Integer pid;
    private String pcolor;
    private String pcolor1;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }

    public String getPcolor1() {
        return pcolor1;
    }

    public void setPcolor1(String pcolor1) {
        this.pcolor1 = pcolor1;
    }


}
