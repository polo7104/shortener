package com.david.shortener.domain;

import lombok.Data;

import java.io.Serializable;


public class UrlVO implements Serializable {

    private int id;
    private String url;
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
