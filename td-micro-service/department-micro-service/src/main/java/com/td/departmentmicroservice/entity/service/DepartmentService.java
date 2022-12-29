package com.td.departmentmicroservice.entity.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.departmentmicroservice.entity.DepartmentEntity;
import com.td.departmentmicroservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity saveDepartment(DepartmentEntity department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public DepartmentEntity getDepartmentById(Long departmentId) {
        log.info("Inside getDepartmentById method of DepartmentService");
        return departmentRepository.getDepartmentByDepartmentId(departmentId);
    }
}