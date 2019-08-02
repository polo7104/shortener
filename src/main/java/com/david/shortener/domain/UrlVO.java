package com.david.shortener.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UrlVO implements Serializable {
    private int id;
    private String url;
    private String createDate;
}
