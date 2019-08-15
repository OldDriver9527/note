package org.olddriver.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class LearnBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("LearnBeanPostProcessor---postProcessBeforeInitialization");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("LearnBeanPostProcessor---postProcessAfterInitialization");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
