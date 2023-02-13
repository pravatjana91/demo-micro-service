package com.td.mybatismicroservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.td.mybatismicroservice.config.MyBatisConfiguration;
import com.td.mybatismicroservice.dto.CityDto;


@Component
public class CityDao {

@Autowired	
  private  SqlSession sqlSession;


@Autowired
@Qualifier(MyBatisConfiguration.secondarySqlSessionTemplate)
private  SqlSession sqlSessionSecondDary;



  public CityDto selectCityById(long id) {
    return this.sqlSession.selectOne("selectCityById", id);
  }

	public CityDto selectCityByIdSecondary(long id) {
		return this.sqlSessionSecondDary.selectOne("selectCityById", id);
	}

}