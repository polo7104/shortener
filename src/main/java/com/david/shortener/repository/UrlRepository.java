package com.david.shortener.repository;

import com.david.shortener.domain.UrlHitVO;
import com.david.shortener.domain.UrlVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UrlRepository {

    String getUrl(int id);

    UrlVO getUrlId(String url);

    boolean isExist(String url);

    void insertUrl(UrlVO vo) throws Exception;

    void insertUrlHit(UrlHitVO vo) throws Exception;

    List<UrlHitVO> getHistory();
}
