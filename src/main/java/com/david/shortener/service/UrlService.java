package com.david.shortener.service;

import com.david.shortener.domain.UrlHitVO;
import com.david.shortener.domain.UrlVO;
import com.david.shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String getUrl (int id){
        return urlRepository.getUrl(id);
    }

    public UrlVO getUrlId(String url) {
        return urlRepository.getUrlId(url);
    }

    public boolean isExist(String url){
        return urlRepository.isExist(url);
    }

    public void insertUrl(UrlVO vo) throws Exception{
        urlRepository.insertUrl(vo);
    }

    public void insertUrlHit(UrlHitVO vo) throws Exception{
        urlRepository.insertUrlHit(vo);
    }

}
