package com.mic.pro.service.admin.domain.service;

import com.mic.pro.service.admin.domain.model.News;

import java.util.List;

public interface NewsService {

    int insert(News news);

    int update(News news);

    int delete(News news);

    List<News> query();

}
