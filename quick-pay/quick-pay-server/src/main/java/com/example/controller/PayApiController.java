package com.example.controller;

import com.example.client.AuthClient;
import com.example.client.BusinessClient;
import com.example.client.PayClient;
import com.example.client.SystemClient;
import com.example.common.base.ResultVO;
import com.example.common.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign/pay")
public class PayApiController implements PayClient {

    @Autowired
    private BusinessClient businessClient;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private AuthClient authClient;
    @Override
    public ResultVO<String> testMethod() {
        System.out.println(businessClient.testMethod());
        System.out.println(systemClient.testMethod());
        //System.out.println(authClient.testMethod());
        return ResultUtils.success("支付服务返回成功！");
    }
}
