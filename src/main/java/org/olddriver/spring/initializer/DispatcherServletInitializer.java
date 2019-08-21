package org.olddriver.spring.initializer;


import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.olddriver.spring.config.ApplicationConfig;
import org.olddriver.spring.config.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 
 * DispatcherServletInitializer DispatcherServlet初始化器
 * 对DispatcherServlet，ContextLoaderListener进行注册
 *
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 指明spring配置类
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ApplicationConfig.class};
	}

	/**
	 * 指明springmvc配置类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	/**
	 * 指明DispatcherServlet url
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	/**
	 * 指明DispatcherServlet 初始化参数
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		//指定激活 profile
		registration.setInitParameter("spring.profiles.active", "development4jndi");
		registration.setInitParameter("spring.profiles.default", "development4c3p0");
		registration.setLoadOnStartup(1);
		
		registration.setMultipartConfig(new MultipartConfigElement("", 1024, 1024, 0));
	}

	/**
	 * 添加Filter的便捷方法
	 * 添加Filter与DispatcherServlet的url一致
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {new CharacterEncodingFilter()};
	}
}
