package com.vincce.fun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vincce.fun.model.UserVo;

/**
  Created By BaoNing On 2019年1月14日
*/
@Mapper
public interface UserMapper {
	
	int insert(UserVo userVo);
	
	int insertSelective(UserVo userVo);
	
	List<UserVo> queryUserList();
	
	UserVo queryUserByUid(@Param("uId") Integer uId);

}
