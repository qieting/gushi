package com.example.gushi.dao;



import javax.persistence.*;

import java.io.Serializable;
@Entity
@IdClass(value = LikeHelp.class)
public class MLike implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private  String number;
    @Id
    private int tangshiid;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTangshiid() {
        return tangshiid;
    }

    public void setTangshiid(int tangshiid) {
        this.tangshiid = tangshiid;
    }
}
