package org.olddriver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@LearnAnnotation(value="注解")
public @interface LearnCombinationAnnotation {
	/*
	 * 组合注解
	 * 在注解上使用非元注解的注解修饰，当前注解就是组合注解
	 * 组合注解包含指定注解的功能
	 */
}
