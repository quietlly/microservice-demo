package com.mic.pro.service.admin.hystrix;

import com.mic.pro.common.web.util.ApiResult;
import com.mic.pro.service.admin.api.NewsApi;
import com.mic.pro.service.admin.model.NewsVo;

import javax.validation.Valid;

public class NewsApiCallback implements NewsApi {

    public static final String SERVICE_ID = "ADMIN-WEB-SERVICE";

    @Override
    public ApiResult<NewsVo> insert(@Valid NewsVo entity) {
        return null;
    }

    @Override
    public ApiResult<NewsVo> update(@Valid NewsVo entity) {
        return null;
    }

    @Override
    public ApiResult<NewsVo> queryById(@Valid Long id) {
        return null;
    }
}
