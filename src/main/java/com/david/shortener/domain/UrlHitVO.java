package com.david.shortener.domain;

import lombok.Data;

@Data
public class UrlHitVO {
    private String url;
    private String ip;
    private String hitDate;
}
