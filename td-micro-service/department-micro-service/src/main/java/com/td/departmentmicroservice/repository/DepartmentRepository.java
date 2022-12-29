package com.td.departmentmicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.td.departmentmicroservice.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
	DepartmentEntity getDepartmentByDepartmentId(Long departmentId);
}