package com.td.mybatismicroservice;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.td.mybatismicroservice.config.MyBatisConfiguration;


@SpringBootApplication
//@MapperScan(basePackages = { "com.td.mybatismicroservice.mapper" }, annotationClass = Mapper.class)
//@MapperScan(basePackages = "com.td.mybatismicroservice.mapper.secondary", sqlSessionFactoryRef=MyBatisConfiguration.ANOTHER_SESSION_FACTORY)

public class SampleMybatisApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleMybatisApplication.class, args);
  }


}