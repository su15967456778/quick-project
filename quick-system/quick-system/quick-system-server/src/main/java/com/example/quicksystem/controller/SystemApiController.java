package com.example.quicksystem.controller;

import com.example.client.SystemClient;
import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/system")
public class SystemApiController implements SystemClient {
    @Override
    public ResultVO<String> testMethod() {
        return ResultUtils.success("系统服务返回成功！");
    }


}
