package com.td.mybatismicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td.mybatismicroservice.dao.CityDao;
import com.td.mybatismicroservice.dto.CityDto;
import com.td.mybatismicroservice.mapper.CityMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/city")
@Slf4j
public class MyBatisController {

	@Autowired
	private CityDao cityDao;

	@Autowired
	private CityMapper cityMapper;

	@GetMapping("java/{id}")
	public CityDto getCityById(@PathVariable("id") Long cityId) {

		CityDto cityDto = this.cityDao.selectCityById(1);
		System.out.println(cityDto);

		return cityDto;
	}

	@GetMapping("xml/{stateCode}")
	public CityDto getCityByXmlId(@PathVariable("stateCode") String stateCode) {
		CityDto cityDto = this.cityMapper.findByState(stateCode);
		System.out.println(cityDto);

		return cityDto;
	}

}