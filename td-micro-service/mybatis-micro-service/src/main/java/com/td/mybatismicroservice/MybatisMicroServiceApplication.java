package com.td.mybatismicroservice;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//@MapperScan(basePackages = { "com.td.mybatismicroservice.mapper" }, annotationClass = Mapper.class)

public class MybatisMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisMicroServiceApplication.class, args);
	}

}
