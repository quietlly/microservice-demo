package com.mic.pro.service.admin.api;

import com.mic.pro.common.web.util.ApiResult;
import com.mic.pro.service.admin.hystrix.NewsApiCallback;
import com.mic.pro.service.admin.model.LoginByPasswordIVO;
import com.mic.pro.service.admin.model.LoginByPasswordOVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = NewsApiCallback.SERVICE_ID, fallback = NewsApiCallback.class)
@RequestMapping("/admin-login-api")
public interface LoginApi {

    @PostMapping(value = "/login/loginByPassword")
    @ResponseBody
    ApiResult<LoginByPasswordOVO> login(@RequestBody LoginByPasswordIVO ivo);

}
