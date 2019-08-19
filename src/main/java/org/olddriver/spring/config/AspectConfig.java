package org.olddriver.spring.config;

import org.olddriver.spring.aspect.LearnAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses= {LearnAspect.class})
public class AspectConfig {

}
