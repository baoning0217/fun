package com.vincce.fun.domain;

import java.io.Serializable;

import lombok.Data;

/**
  Created By BaoNing On 2019年1月14日
*/
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer uId;
	
	private String name;
	
	private Boolean sex;
	
	private String email;
	
	private String location;
	

}
