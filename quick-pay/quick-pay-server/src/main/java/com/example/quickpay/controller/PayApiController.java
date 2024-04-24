package com.example.quickpay.controller;

import com.example.client.BusinessClient;
import com.example.client.PayClient;
import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign/pay")
public class PayApiController implements PayClient {

/*    @Autowired
    private BusinessClient businessClient;*/
    @Override
    public ResultVO<String> testMethod() {
        //System.out.println(businessClient.testMethod());
        return ResultUtils.success("支付服务返回成功！");
    }
}
