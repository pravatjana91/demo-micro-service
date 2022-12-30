package com.td.departmentmicroservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.td.departmentmicroservice.entity.DepartmentEntity;
import com.td.departmentmicroservice.entity.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
//@Slf4j
public class DepartmentController {
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    
    @Autowired
    private DepartmentService departmentService;

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
}