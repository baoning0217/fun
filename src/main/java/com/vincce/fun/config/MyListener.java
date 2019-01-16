package com.vincce.fun.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
  Created By BaoNing On 2019年1月15日
  
  监听器
  
  @WebListener:将一个实现了特定监听器接口的类定义为监听器
  
  常见监听：
  	1.对Request的监听有ServletRequestListener和ServletRequestAttributeListener。
  		前者可见监听Request的创建和销毁；而后者可以对Request的属性进行监听。
  		
	2.对Session的监听有HttpSessionListener和HttpSessionAttributeListener。
		HttpSessionListener可以监听HttpSession的创建跟销毁，而HttpSessionAttributeListener则是对session中属性的监听，
		它可以监听到session新增属性、移除属性和属性值被替换时。
		
	3.对于ServletContext的监听器有ServletContextListener和ServletContextAttributeListener。
		ServletContextListener可以监听到ServletContext的创建和销毁，
		而ServletContextAttributeListener可以监听到ServletContext中属性的新增、移除和属性值的替换。
  
*/
@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}



}
