package com.vincce.fun.model;

import java.util.List;

import com.vincce.fun.domain.User;

import lombok.Data;

/**
  Created By BaoNing On 2019年1月14日
*/
@Data
public class UserVo extends User{
	
	public List<Integer> roleId;
	
	public String desc;
	

}
