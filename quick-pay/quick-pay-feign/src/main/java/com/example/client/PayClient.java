package com.example.client;

import com.example.common.base.ResultVO;
import com.example.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "quick-pay",path = "/feign/pay", configuration = FeignConfig.class , fallback = PayClientFallback.class)
public interface PayClient {
    @GetMapping("/test")
    ResultVO<String> testMethod();

}
