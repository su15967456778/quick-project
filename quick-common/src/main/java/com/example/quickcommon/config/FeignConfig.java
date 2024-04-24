package com.example.quickcommon.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = {"com.example.client"})
public class FeignConfig {

}
