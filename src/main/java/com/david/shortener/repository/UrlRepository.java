package com.david.shortener.repository;

import com.david.shortener.domain.UrlHitVO;
import com.david.shortener.domain.UrlVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UrlRepository {

    List<UrlVO> getUrl(String id);

    boolean isExist(String url);

    void insertUrl(UrlVO vo) throws Exception;

    void insertUrlHit(UrlHitVO vo) throws Exception;
}
