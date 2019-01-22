package com.vincce.fun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
  Created By BaoNing On 2019年1月19日
  
  描述：security配置类
  
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * 用来配置拦截保护请求，比如什么请求放行，什么请求需要验证
	 */
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
		
		//密码编码器
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth
			//使用内存存储
			.inMemoryAuthentication()
			//设置密码编码器
			.passwordEncoder(passwordEncoder)
			.withUser("admin").password("123456").roles("USER","ADMIN")
			.and()
			.withUser("baoning").password("123456").roles("USER");
	}

	/**
	 * 用来配置Filter链
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	
	
}
