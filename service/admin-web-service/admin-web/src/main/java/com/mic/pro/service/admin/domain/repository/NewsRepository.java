package com.mic.pro.service.admin.domain.repository;

import com.mic.pro.service.admin.domain.model.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsRepository {

    int insert(News news);

    int update(News news);

    int delete(News news);

    List<News> query();

}
