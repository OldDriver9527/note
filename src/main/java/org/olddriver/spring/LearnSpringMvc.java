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
	 * 5.DispatcherServlet 使用视图解析器寻找视图名对应的视图
	 * 6.DispatcherServlet 将模型 交给视图进行渲染
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
	 * 启用springmvc引入默认配置，存在两种方式引入mvc默认配置
	 * 1.在配置类上使用@EnableWebMvc 注解，引入springmvc默认配置
	 * 2.使配置类继承WebMvcConfigurationSupport ，引入配置；具有单继承局限性
	 * 
	 * springmvc解决无法访问静态资源（js，css，html）问题
	 * 使配置类实现WebMvcConfigurer接口，override configureDefaultServletHandling方法
	 * 调用DefaultServletHandlerConfigurer的enable方法
	 * 
	 * springmvc配置视图解析器
	 * 在配置类中，使用方法配置，使用@Bean注解，将视图解析器加入springmvc容器
	 * 使用视图解析器通过视图名称,寻找相关视图
	 * InternalResourceViewResolver 一般用于 jsp视图
	 * 
	 * 声明控制器
	 * 使用@Controller注解标识 控制器
	 * 控制器中使用@RequestMapping注解 标识处理器方法，@RequestMapping使用在类上时，
	 * 类中所有处理器方法会继承该配置，与方法上配置合并
	 * 处理器方法返回的字符串会作为视图名，由控制器交给DispatcherServlet
	 * 
	 * 使用模型为视图传递数据
	 * 在处理器方法参数列表中定义模型（Model），方法结束，模型中的属性会添加到request中
	 * 
	 * 获取请求参数
	 * @RequestParam
	 * 使用@RequestParam注解将查询字符串中或请求体中 请求参数 绑定到方法参数
	 * 若方法参数类型为map，且注解中未指定请求参数名称，将所有类型匹配的请求参数填充进map
	 * @RequestHeader
	 * 使用@RequestHeader注解将请求标头绑定到方法参数
	 * @CookieValue
	 * 使用@CookieValue注解将HTTP cookie的值绑定到方法参数
	 * @RequestBody
	 * @RequestBody注解通过HttpMessageConverter将请求体读取并反序列化为Object，之后绑定到方法参数
	 * 
	 * @ResponseBody
	 * @ResponseBody注解通过HttpMessageConverter将处理器方法返回序列化到响应体
	 * 
	 * thymeleaf模板
	 */
}