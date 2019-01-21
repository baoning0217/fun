package com.vincce.fun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
  Created By BaoNing On 2019年1月19日
  
  描述：security配置类
  
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 路由策略和访问权限得简单配置
		http
			.formLogin() //启用默认登录页面
			.failureUrl("/login?error") //登陆失败返回url:/login?error
			.defaultSuccessUrl("/users") //登录成功跳转URL
			.permitAll(); //登录页面全部权限可访问
		super.configure(http);
	}
	
	/**
	 * 配置内存用户
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("123456").roles("ADMIN");
	}
	
}
