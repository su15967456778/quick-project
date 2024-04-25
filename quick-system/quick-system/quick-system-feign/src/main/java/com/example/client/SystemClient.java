package com.example.client;

import com.example.common.base.ResultVO;
import com.example.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "quick-system",path = "/feign/system", configuration = FeignConfig.class , fallback = SystemClientFallback.class)
public interface SystemClient {
    @GetMapping("/test")
    ResultVO<String> testMethod();

}
