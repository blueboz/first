package com.pizza.domain;

import java.io.Serializable;
import java.util.Date;

public class Qingjiadan implements Serializable{

    private String user;
    private Date date;
    private String reason;



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
