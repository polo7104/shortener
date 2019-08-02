package com.david.shortener.repository;

import com.david.shortener.domain.UrlVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UrlRepository {

    List<UrlVO> getUrl(String url);
}
