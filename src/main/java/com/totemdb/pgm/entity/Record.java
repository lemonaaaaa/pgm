package com.totemdb.pgm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Record {
    @Id
    private Long id;
    private Long bookid;
    private Long userid;
    private Timestamp karutime;
    private Timestamp kaesutime;
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setKarutime(Timestamp karutime) {
        this.karutime = karutime;
    }

    public void setKaesutime(Timestamp kaesutime) {
        this.kaesutime = kaesutime;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getBookid() {
        return bookid;
    }

    public Long getUserid() {
        return userid;
    }

    public Timestamp getKarutime() {
        return karutime;
    }

    public Timestamp getKaesutime() {
        return kaesutime;
    }

    public Long getStatus() {
        return status;
    }
}
