package com.mic.pro.service.admin.domain.service.impl;

import com.mic.pro.service.admin.domain.model.News;
import com.mic.pro.service.admin.domain.repository.NewsRepository;
import com.mic.pro.service.admin.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public int insert(News news) {
        return newsRepository.insert(news);
    }

    @Override
    public int update(News news) {
        return newsRepository.update(news);
    }

    @Override
    public int delete(News news) {
        return newsRepository.delete(news);
    }

    @Override
    public List<News> query() {
        return newsRepository.query();
    }
}
