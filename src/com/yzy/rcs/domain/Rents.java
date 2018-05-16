package com.yzy.rcs.domain;

import com.yzy.rcs.vo.PageVo;

import java.sql.Timestamp;

public class Rents extends PageVo{
    private String rentid;
    private Double price;
    private String begindate;
    private String returndate;
    private String rentflag;
    private String custid;
    private String carid;
    private String username;

    public String getRentid() {
        return rentid;
    }

    public void setRentid(String rentid) {
        this.rentid = rentid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getRentflag() {
        return rentflag;
    }

    public void setRentflag(String rentflag) {
        this.rentflag = rentflag;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
