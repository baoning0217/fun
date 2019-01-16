package com.vincce.fun.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
  Created By BaoNing On 2019年1月14日
  
  定义拦截器
  
  两种方式：
  - 1.实现HandlerInterceptor接口
  - 2.继承HandlerInterceptorAdapter
  
  - preHandle
  	- true：放行
  	- false：拦截
  
*/
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle....");
		System.out.println("preHandle........");
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle....");
		System.out.println("postHandle........");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion....");
		System.out.println("afterCompletion........");
	}
	
	

}
