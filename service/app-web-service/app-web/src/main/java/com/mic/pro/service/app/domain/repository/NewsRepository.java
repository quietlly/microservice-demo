package com.mic.pro.service.app.domain.repository;


import com.mic.pro.service.app.domain.model.News;
import org.mapstruct.Mapper;
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
