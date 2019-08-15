package org.olddriver.spring.config;

import org.olddriver.spring.bean.ExampleBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses= {ExampleBean.class})
public class EntityConfig {
	
}
