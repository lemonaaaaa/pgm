package com.totemdb.pgm.entity;

import java.sql.Timestamp;

public class book {
    private Long id;
    private String title;
    private String author;
    private Timestamp publishtime;
    private Long total;
    private Long available;
    private Long count;
    private boolean show;
    private String index;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public Timestamp getPublishtime() {
        return publishtime;
    }

    public Long getTotal() {
        return total;
    }

    public Long getAvailable() {
        return available;
    }

    public Long getCount() {
        return count;
    }

    public boolean isShow() {
        return show;
    }

    public String getIndex() {
        return index;
    }
}
