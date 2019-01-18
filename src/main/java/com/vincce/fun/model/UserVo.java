package com.vincce.fun.model;

import java.io.Serializable;
import java.util.List;

import com.vincce.fun.domain.User;

import lombok.Data;

/**
  Created By BaoNing On 2019年1月14日
*/
@Data
public class UserVo extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	public List<Integer> roleId;
	
	public String desc;
	

}
