package org.olddriver.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {ServiceConfig.class,EntityConfig.class,AspectConfig.class,SpringDataJpaConfig.class,SpringDataJpaAuditingConfig.class,RedisConfig.class})
public class ApplicationConfig {

}
