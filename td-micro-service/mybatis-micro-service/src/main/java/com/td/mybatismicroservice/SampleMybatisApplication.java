package com.td.mybatismicroservice;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.td.mybatismicroservice.dao.CityDao;
import com.td.mybatismicroservice.mapper.CityMapper;

@SpringBootApplication
@MapperScan(basePackages = { "com.td.mybatismicroservice.mapper" }, annotationClass = Mapper.class)

public class SampleMybatisApplication implements CommandLineRunner {


@Autowired	
private  CityDao cityDao;

   
@Autowired	
private  CityMapper cityMapper;

  public static void main(String[] args) {
    SpringApplication.run(SampleMybatisApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    
    System.out.println(this.cityDao.selectCityById(1));

    System.out.println(this.cityMapper.findByState("WB"));
  }

}