package com.mic.pro.service.admin.controller;

import com.mic.pro.common.web.util.ApiResult;
import com.mic.pro.service.admin.api.LoginApi;
import com.mic.pro.service.admin.model.LoginByPasswordIVO;
import com.mic.pro.service.admin.model.LoginByPasswordOVO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {
    @Override
    public ApiResult<LoginByPasswordOVO> login(LoginByPasswordIVO ivo) {
        LoginByPasswordOVO ovo = new LoginByPasswordOVO();
        ovo.setPassword(ivo.getPassword());
        ovo.setUserName(ivo.getUserName());
        ovo.setTelephone("180****0000");
        ovo.setUserId("1001");
        return ApiResult.succ(ovo);
    }
}
