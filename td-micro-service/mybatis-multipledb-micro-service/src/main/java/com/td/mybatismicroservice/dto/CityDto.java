package com.td.mybatismicroservice.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityDto implements Serializable {

	  private static final long serialVersionUID = 1L;

	  private Long id;

	  private String name;

	  private String state;

	  private String country;
	  
}