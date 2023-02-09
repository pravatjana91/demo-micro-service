package com.td.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallBack")
    public String orderServiceFallback() {
        return "User Service is down!";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallback() {
        return "Department Service is down!";
    }

    @GetMapping("/mybatisServiceFallBack")
    public String mybatisServiceFallback() {
        return "MYBATIS Service is down!";
    }

}