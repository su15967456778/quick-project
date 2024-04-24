package com.example.client;

import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "quick-business", path = "/feign/business", configuration = FeignConfig.class , fallback = BusinessClientFallback.class)
public interface BusinessClient {
    @GetMapping("/test")
    ResultVO<String> testMethod();

}
