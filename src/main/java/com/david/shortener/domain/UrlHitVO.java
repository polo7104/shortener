package com.david.shortener.domain;

import lombok.Data;


public class UrlHitVO {

    private String url;
    private String ip;
    private String hitDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHitDate() {
        return hitDate;
    }

    public void setHitDate(String hitDate) {
        this.hitDate = hitDate;
    }


}
