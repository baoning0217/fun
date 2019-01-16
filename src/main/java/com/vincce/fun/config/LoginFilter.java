package com.vincce.fun.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
  Created By BaoNing On 2019年1月15日
  
  @WebFilter:用于将一个类声明为过滤器，该注解将会在部署时被容器处理，容器将根据具体的属性配置将相应的类部署为过滤器。
  	- urlPatterns：指定一组过滤器的 URL 匹配模式。等价于 <url-pattern> 标签。
  	- filterName：指定过滤器的 name 属性，等价于 <filter-name>
  	- value：该属性等价于 urlPatterns 属性。但是两者不应该同时使用。
	- servletNames：指定过滤器将应用于哪些 Servlet。取值是 @WebServlet 中的 name 属性的取值，或者是 web.xml 中 <servlet-name> 的取值。
	- dispatcherTypes：指定过滤器的转发模式。具体取值包括：ASYNC、ERROR、FORWARD、INCLUDE、REQUEST。
	- initParams：指定一组过滤器初始化参数，等价于 <init-param> 标签。
	- asyncSupported：声明过滤器是否支持异步操作模式，等价于 <async-supported> 标签。
	- description：该过滤器的描述信息，等价于 <description> 标签。
	- displayName：该过滤器的显示名，通常配合工具使用，等价于 <display-name> 标签。
  
*/
@Component
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}
	
	
	

}
