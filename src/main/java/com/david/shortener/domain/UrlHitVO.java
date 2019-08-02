package com.david.shortener.domain;


public class UrlHitVO {

    private String url;
    private String ip;
    private String hit_date;

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

    public String getHit_date() {
        return hit_date;
    }

    public void setHit_date(String hit_date) {
        this.hit_date = hit_date;
    }


}
