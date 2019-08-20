package org.olddriver.spring;
/**
 * 
 * springMvc 笔记
 *
 */
public class LearnSpringMvc {
	/*
	 * springMvc
	 * springMvc 基于servlet api构建的原始Web框架
	 * 
	 * springMvc 处理请求的过程
	 * 1.请求到达DispatcherServlet
	 * 2.DispatcherServlet 查询处理器映射，寻找请求关联的处理器方法
	 * 3.DispatcherServlet将请求发送给控制器中处理器方法
	 * 4.控制器完成请求处理，将模型，视图名发送给DispatcherServlet
	 * 5.DispatcherServlet 使用视图解析器寻找视图名对应的视图实现
	 * 6.DispatcherServlet 将模型 交给视图渲染
	 * 7.视图将渲染结果回送浏览器
	 * 
	 * 配置DispatcherServlet
	 * 使用AbstractAnnotationConfigDispatcherServletInitializer配置DispatcherServlet
	 * AbstractAnnotationConfigDispatcherServletInitializer 是 WebApplicationInitializer的实现
	 * spring提供SpringServletContainerInitializer 会在服务启动时调用调用所有WebApplicationInitializer的
	 * onStartup方法，AbstractAnnotationConfigDispatcherServletInitializer在onStartup方法中对
	 * ContextLoaderListener，DispatcherServlet进行配置，
	 * getRootConfigClasses 用于传入spring配置类，创建spring应用上下文时使用
	 * getServletConfigClasses 用于传入springmvc配置类，创建springmvc应用上下文时使用
	 * getServletMappings 用于传入DispatcherServlet url
	 * customizeRegistration 用于配置DispatcherServlet 初始化参数
	 * getServletFilters 注册filter的便捷方法，但filter 与DispatcherServlet 的url一致
	 * 
	 * 启用springmvc
	 * 在配置类上使用@EnableWebMvc 注解启用springmvc，引入springmvc默认配置
	 */
}
