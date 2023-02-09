package com.td.mybatismicroservice.dto;


import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class FundManagerVO implements Serializable  {
	
	private Long fundManagerId;
	private String profileName;
	private Long imageBlobId;
	private String title;
	private String credentials;
	private String experience;
	private String biodata;
	private String titleFrench;
	private String credentialFrench;
	private String experienceFrench;
	private String biodataFrench;
	private String updatedBy;
	private Boolean deleted;
	private String lang;
	
	
}

