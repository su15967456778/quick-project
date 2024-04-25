package com.example.client;

import com.example.common.base.ResultVO;
import com.example.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "quick-auth", path = "/feign/auth", configuration = FeignConfig.class , fallback = AuthClientFallback.class)
public interface AuthClient {
    @GetMapping("/test")
    ResultVO<String> testMethod();

}
