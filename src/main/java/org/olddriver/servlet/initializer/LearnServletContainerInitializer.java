package org.olddriver.servlet.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
/**
 * 
 * ServletContainerInitializer 笔记
 *
 */
public class LearnServletContainerInitializer implements ServletContainerInitializer{
	/*
	 * ServletContainerInitializer 
	 * 用于动态注册 servlet，filter，listener
	 * ServletContainerInitializer 通过SPI（Service Provider Interface）机制实现
	 * 创建ServletContainerInitializer 实现类后，
	 * 在类的根路径下创建META-INF/services 目录，其中创建javax.servlet.ServletContainerInitializer文件，
	 * 文件中存放ServletContainerInitializer实现类的类全名
	 * 那么所有ServletContainerInitializer实现类的onStartup方法会在服务启动时执行
	 */
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("LearnServletContainerInitializer---onStartup");
	}
}