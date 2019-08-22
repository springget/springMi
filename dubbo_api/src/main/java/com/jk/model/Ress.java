package com.jk.model;

import java.io.Serializable;

public class Ress implements Serializable {

    private Integer ressid;

    private String ressname;//地址名称

    private String resssite;//地址编码

    private String resslabel;//地址标签

    private Integer userId;//地址标签

    private String ressusername; //收件人名字

    private String ressuserPhone;//收件人手机号

    public String getRessuserPhone() {
        return ressuserPhone;
    }

    public void setRessuserPhone(String ressuserPhone) {
        this.ressuserPhone = ressuserPhone;
    }



    public String getRessusername() {
        return ressusername;
    }

    public void setRessusername(String ressusername) {
        this.ressusername = ressusername;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getRessid() {
        return ressid;
    }

    public void setRessid(Integer ressid) {
        this.ressid = ressid;
    }

    public String getRessname() {
        return ressname;
    }

    public void setRessname(String ressname) {
        this.ressname = ressname;
    }

    public String getResssite() {
        return resssite;
    }

    public void setResssite(String resssite) {
        this.resssite = resssite;
    }

    public String getResslabel() {
        return resslabel;
    }

    public void setResslabel(String resslabel) {
        this.resslabel = resslabel;
    }
}