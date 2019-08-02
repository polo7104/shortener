package com.david.shortener.service;

import com.david.shortener.domain.UrlVO;
import com.david.shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public List<UrlVO> getUrl (String url){
        return urlRepository.getUrl(url);
    }
}
