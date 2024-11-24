package com.totemdb.pgm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Log {
    @Id
    private Long id;
    private Long userid;
    private Long type;
    private Timestamp regtime;
    private String info;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userid;
    }

    public Long getType() {
        return type;
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public String getInfo() {
        return info;
    }
}
