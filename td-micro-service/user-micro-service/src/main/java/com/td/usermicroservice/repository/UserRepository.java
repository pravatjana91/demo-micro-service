package com.td.usermicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.td.usermicroservice.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity getDepartmentByDepartmentId(Long departmentId);

	UserEntity findByUserId(Long userId);
}