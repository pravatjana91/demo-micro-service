package com.td.mybatismicroservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mybatismicroservice.dto.CityDto;


@Component
public class CityDao {

@Autowired	
  private  SqlSession sqlSession;

  public CityDto selectCityById(long id) {
    return this.sqlSession.selectOne("selectCityById", id);
  }

}