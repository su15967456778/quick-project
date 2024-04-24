package com.example.quickbusiness.controller;

import com.example.client.BusinessClient;
import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/business")
public class BusinessApiController implements BusinessClient {
    @Override
    public ResultVO<String> testMethod() {
        return ResultUtils.success("业务服务返回成功！");
    }


}
