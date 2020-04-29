package com.example.gushi.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Tangshi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    public String getShiju() {
        return shiju;
    }

    public void setShiju(String shiju) {
        this.shiju = shiju;
    }

    public String getYiwen() {
        return yiwen;
    }

    public void setYiwen(String yiwen) {
        this.yiwen = yiwen;
    }

    public String getZhushi() {
        return zhushi;
    }

    public void setZhushi(String zhushi) {
        this.zhushi = zhushi;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "leixing")
    private String leixing;

    @Column(name = "zuozhe")
    private String zuozhe;

    @Column(name = "shiju")
    private String shiju;

    @Column(name = "yiwen")
    private String yiwen;
    @Column(name = "zhushi")
    private String zhushi;


}
