package com.vincce.fun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincce.fun.dto.UserDto;
import com.vincce.fun.model.UserVo;
import com.vincce.fun.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
  Created By BaoNing On 2019年1月14日
*/
@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	/**
	 * 插入数据
	 * @return
	 */
	@PostMapping("/")
	public Integer insertUser(@RequestBody UserDto userDto) {
		return userService.insertUser(userDto.getUserVo());
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@GetMapping("/")
	public List<UserVo> getUserList() {
		log.debug("执行list");
		return userService.getUserList();
	}
	
	/**
	 * 获取所有用户姓名
	 * @return
	 */
	@GetMapping("/name")
	public List<String> getNames() {
		return userService.getUserNameList();
	}
	
	
	/**
	 * 获取编辑后的所有用户
	 * @return
	 */
	@GetMapping("/users")
	public List<UserVo> getUsers() {
		return userService.getUsersEdit();
	}
	
	/**
	 * 通过id获取用户
	 * @return
	 */
	@GetMapping("/{uId}")
	public UserVo getUserByUid(@PathVariable("uId")Integer uId) {
		return userService.getUserByUid(uId);
	}
	
	

}
