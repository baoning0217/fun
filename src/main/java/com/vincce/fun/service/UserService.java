package com.vincce.fun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vincce.fun.mapper.UserMapper;
import com.vincce.fun.model.UserVo;

/**
  Created By BaoNing On 2019年1月14日
*/
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	/**
	 * 插入数据
	 * @param userVo
	 * @return
	 */
	public Integer insertUser(UserVo userVo) {
		userMapper.insert(userVo);

		//先将数据缓存
		redisTemplate.opsForValue().set(userVo.getUId().toString()+ "-" + userVo.getName(), userVo.getName()+userVo.getEmail());
		return userVo.getUId();
	}
	
	/**
	 * 插入用户数据
	 * @param userVo
	 * @return
	 */
	public Integer insertSelectiveUser(UserVo userVo) {
		userMapper.insertSelective(userVo);
		return userVo.getUId();
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	public List<UserVo> getUserList() {
		return userMapper.queryUserList();
	}
	
	/**
	 * 用流截取信息
	 * @return
	 */
	public List<String> getUserNameList(){
		List<UserVo> userList = userMapper.queryUserList();
		List<String> names = userList.stream()
				.filter(u-> u.getSex() != false)
				.map(UserVo::getLocation)
				.collect(Collectors.toList());	
		return names;
	}
	
	/**
	 * 设置返回用户属性值
	 * @return
	 */
	public List<UserVo> getUsersEdit() {
		//查询当前系统中的用户
		List<UserVo> users = userMapper.queryUserList();
		
		//用流的方式取出属性值
		List<Integer> uids = users.stream().map(UserVo::getUId).collect(Collectors.toList());
		
		//将值放入新添加的属性中 返回给前端显示 增加额外的属性
		users.stream().forEach(uservo->{
			uservo.setRoleId(uids);
		});
		return users;
	}
	
	/**
	 * 通过id获取用户
	 * BeanUtils.copyProperties测试
	 * @param uId
	 * @return
	 */
	public UserVo getUserByUid(Integer uId) {

		//从redis中获取数据
		Object o = redisTemplate.opsForValue().get(uId.toString());

		if (o != null){
			return (UserVo) o;
		}

		//将查询的属性值 赋值到另外一个对象上
		UserVo userVo = userMapper.queryUserByUid(uId);
		UserVo user = new UserVo();
		
		user.setLocation("北京");
		
		//属性赋值，节省set，get方法
		BeanUtils.copyProperties(userVo, user);
		
		List<Integer> ids = new ArrayList<>();
		ids.add(userVo.getUId());
		user.setRoleId(ids);
		return user;
	}
	

}
