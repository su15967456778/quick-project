package com.example.client;

import com.example.common.base.ResultVO;
import com.example.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "quick-business", path = "/feign/business", configuration = FeignConfig.class , fallback = BusinessClientFallback.class)
public interface BusinessClient {
    @GetMapping("/test")
    ResultVO<String> testMethod();

}
