package com.td.mybatismicroservice.mapper.secondary;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Select;

import com.td.mybatismicroservice.dto.CityDto;

@Mapper
public interface CityMapperSecondary {

	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
})
  @Select("SELECT * FROM CITY WHERE state = #{state}")
  CityDto findByState(@Param("state") String state);

}