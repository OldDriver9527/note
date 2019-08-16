package org.olddriver.spring.bean;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class ExampleBean implements 
BeanNameAware,
BeanFactoryAware,
ApplicationContextAware,
InitializingBean,
DisposableBean{
	
	private String attribute;
	public ExampleBean() {
		System.out.println("默认构造器");
	}
	@Autowired
	public ExampleBean(@Value(value="hello value") String argu) {
		System.out.println("有参构造器-----"+argu);
	}
	
	public ExampleBean(List<String> list) {
		System.out.println("有参构造器-----"+list);
	}
	
	@Autowired
	public void testAutowired() {
		System.out.println("ExampleBean ------ testAutowired");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("ExampleBean ---- setBeanName ----"+name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("ExampleBean ---- setBeanFactory ----"+beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ExampleBean ---- setApplicationContext ----"+applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ExampleBean ---- afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("ExampleBean ---- destroy");
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
