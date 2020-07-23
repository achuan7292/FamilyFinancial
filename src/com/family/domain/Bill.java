package com.family.domain;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable{
    private Integer bid;

    private Integer bKinds;

    private String bDesc;

    private String bDate;

    private Double bMoney;

    private String uid;

    private Long bNumber;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getbKinds() {
        return bKinds;
    }

    public void setbKinds(Integer bKinds) {
        this.bKinds = bKinds;
    }

    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc == null ? null : bDesc.trim();
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate.substring(0,10);
        System.out.println(this.bDate);
    }

    public Double getbMoney() {
        return bMoney;
    }

    public void setbMoney(Double bMoney) {
        this.bMoney = bMoney;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Long getbNumber() {
        return bNumber;
    }

    public void setbNumber(Long bNumber) {
        this.bNumber = bNumber;
    }
}