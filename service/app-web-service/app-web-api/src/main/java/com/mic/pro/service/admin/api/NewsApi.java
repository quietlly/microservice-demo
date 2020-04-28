package com.mic.pro.service.admin.api;

import com.mic.pro.common.web.util.ApiResult;
import com.mic.pro.service.admin.hystrix.NewsApiCallback;
import com.mic.pro.service.admin.model.NewsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = NewsApiCallback.SERVICE_ID, fallback = NewsApiCallback.class)
@RequestMapping("/web-news-api")
public interface NewsApi {

    @PostMapping("/news")
    @ResponseBody
    ApiResult<NewsVo> insert(@Valid @RequestBody NewsVo entity);

    @PutMapping("/news/{id}")
    @ResponseBody
    ApiResult<NewsVo> update(@Valid @RequestBody NewsVo entity);

    @GetMapping("/news/{id}")
    @ResponseBody
    ApiResult<NewsVo> queryById(@Valid @PathVariable Long id);

}
