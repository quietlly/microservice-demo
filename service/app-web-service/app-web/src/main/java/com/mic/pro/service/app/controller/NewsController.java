package com.mic.pro.service.app.controller;

import com.mic.pro.common.web.util.ApiResult;
import com.mic.pro.service.admin.api.NewsApi;
import com.mic.pro.service.admin.model.NewsVo;
import com.mic.pro.service.app.domain.model.News;
import com.mic.pro.service.app.domain.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController implements NewsApi {

    @Autowired
    public NewsService newsService;

    @Override
    public ApiResult<NewsVo> insert(NewsVo entity) {
        News news = new News();
        BeanUtils.copyProperties(entity,news);
        newsService.insert(news);
        return ApiResult.succ(entity);
    }

    @Override
    public ApiResult<NewsVo> update(NewsVo entity) {
        //do something
        return null;
    }

    @Override
    public ApiResult<NewsVo> queryById(Long id) {
        //do something
        return null;
    }
}
