package com.td.mybatismicroservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.td.mybatismicroservice.dto.CityDto;

@Mapper
public interface CityMapper {

  @Select("SELECT * FROM CITY WHERE state = #{state}")
  CityDto findByState(@Param("state") String state);

}