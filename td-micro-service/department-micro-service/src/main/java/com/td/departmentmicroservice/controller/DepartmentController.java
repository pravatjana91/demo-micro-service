package com.td.departmentmicroservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.td.departmentmicroservice.entity.DepartmentEntity;
import com.td.departmentmicroservice.entity.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;
@RefreshScope
@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private Environment env;
    
    @PostMapping("/")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside getDepartmentById method of DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    
    @Value("${message}")
    private String testValue;
    
    @GetMapping("/message")
    public String getPropertyValue() {
        log.info("Inside getDepartmentById method of DepartmentController");
        
        return testValue;
    }

    @GetMapping("/message/{prop}")
    public String getPropertyValue1(@PathVariable("prop") String prop) {
        log.info("Inside getDepartmentById method of DepartmentController");
        log.info("Prop is ->"+ env.getProperty(prop));

        return testValue;
    }

    
    
}