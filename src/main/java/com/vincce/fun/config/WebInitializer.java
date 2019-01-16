package com.vincce.fun.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
  Created By BaoNing On 2019年1月14日
  
   可以看着是web.xml的代替，是一个接口。实现后，可以添加servlet、listener，在加载web项目时，会加载这个接口实现类，从而起到web.xml相同的作用。
  
*/
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		@SuppressWarnings("resource")
		AnnotationConfigWebApplicationContext ac =  new AnnotationConfigWebApplicationContext();
		ac.register();
		ac.refresh();
		
		//创建并且注册DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet();
		Dynamic registration  = servletContext.addServlet("app",servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
		
	}
	
	

}
