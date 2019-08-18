package org.olddriver.spring.config;

import java.util.HashMap;

import org.olddriver.spring.bean.ExampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses= {ExampleBean.class})
public class EntityConfig {
	
	@Bean
	public ExampleBean exampleBeanRegistration() {
		ExampleBean exampleBean = new ExampleBean();
		return exampleBean;
	}
	
	@Bean
	public HashMap<String, Object> exampleMapRegistration() {
		HashMap<String, Object> exampleMap = new HashMap<String, Object>();
		exampleMap.put("currentTimeMillis", System.currentTimeMillis());
		return exampleMap;
	}
}
