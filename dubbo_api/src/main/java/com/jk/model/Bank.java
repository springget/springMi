package com.jk.model;

import java.io.Serializable;

public class Bank  implements Serializable {

    private Integer bankId; //银行卡ID;
    private String bankInfo; //银行卡名称;
    private String bankName; //持卡人名称;
    private String bankPassword; //持卡人密码;
    private Double bankMoney;  //金额;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public Double getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(Double bankMoney) {
        this.bankMoney = bankMoney;
    }
}
