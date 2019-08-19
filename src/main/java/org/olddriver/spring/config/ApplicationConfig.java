package org.olddriver.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {ServiceConfig.class,EntityConfig.class,DataSourceConfig.class,AspectConfig.class})
public class ApplicationConfig {

}
