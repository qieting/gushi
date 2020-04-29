package com.example.gushi.dao;

import java.io.Serializable;
import java.util.Objects;

public class LikeHelp implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeHelp likeHelp = (LikeHelp) o;
        return tangshiid == likeHelp.tangshiid &&
                Objects.equals(number, likeHelp.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, tangshiid);
    }

    private  String number;
    private int tangshiid;
}
