package com.totemdb.pgm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class paper {
    @Id
    private Long id;
    private String title;
    private String author;
    private String uploader;
    private Timestamp uploadtime;
    private Long count;
    private boolean show;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUploader() {
        return uploader;
    }

    public Timestamp getUploadtime() {
        return uploadtime;
    }

    public Long getCount() {
        return count;
    }

    public boolean isShow() {
        return show;
    }
}
