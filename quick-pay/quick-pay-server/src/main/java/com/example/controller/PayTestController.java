package com.example.controller;

import com.example.client.AuthClient;
import com.example.client.BusinessClient;
import com.example.client.PayClient;
import com.example.client.SystemClient;
import com.example.common.aspect.MethodLog;
import com.example.common.base.ResultVO;
import com.example.common.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayTestController {
    @GetMapping("/test/method")
    public ResultVO<String> testMethod() {
        return ResultUtils.success("支付服务测试返回成功！");
    }
}
