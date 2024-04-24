package com.example.quickauth.controller;

import com.example.client.AuthClient;
import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/auth")
public class AuthApiController implements AuthClient {
    @Override
    public ResultVO<String> testMethod() {
        return ResultUtils.success("鉴权服务返回成功！");
    }


}
