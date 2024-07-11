package com.example.ch11_ex1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.ch11_ex1.proxy")
public class ProjectConfig {

}
