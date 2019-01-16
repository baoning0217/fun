package com.vincce.fun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
  Created By BaoNing On 2019年1月14日
  
  两种方法：
  - 1.实现WebMvcConfigurer接口
  - 2.继承WebMvcConfigurerAdapter，目前已过期。
  
*/
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/users/**");
	}
	
}
