package com.example;

import com.example.client.BusinessClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class QuickPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickPayApplication.class, args);
    }

}
