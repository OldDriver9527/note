package org.olddriver.spring;
/**
 * 
 * springMvc 笔记
 * thymeleaf 中文文档仓库	jack80342/Thymeleaf-Reference-Guide
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
	 * ？？？？
	 * 
	 * springmvc文件上传
	 * DispatcherServlet 使用 MultipartResolver（Multipart 解析器）处理 内容类型为multipart/form-data的POST请求
	 * 解析器会解析内容并将当前的HttpServletRequest包装为 MultipartHttpServletRequest，以提供对已解析部分的访问
	 * spring提供多个MultipartResolver实现
	 * StandardServletMultipartResolver	基于Servlet 3.0实现
	 * CommonsMultipartResolver	基于Apache Commons FileUpload实现
	 * 建议使用StandardServletMultipartResolver，不需额外依赖
	 * 
	 * 配置StandardServletMultipartResolver
	 * 在springmvc配置类中，配置名称为multipartResolver的bean
	 * 配置完毕，就会启用多部分处理
	 * 通过DispatcherServlet 控制 临时文件存储位置，
	 * 											上传文件最大尺寸（字节为单位），
	 * 											多部分请求最大尺寸（字节为单位），
	 * 											文件写入磁盘临界尺寸（字节为单位）
	 * 
	 * 配置CommonsMultipartResolver
	 * 在springmvc配置类中，配置名称为multipartResolver的bean
	 * 通过CommonsMultipartResolver 设置上传文件细节
	 * 
	 * 在处理器方法参数列表中使用MultipartFile接收上传文件
	 * 
	 * 异常处理
	 * 使用异常处理器处理当前控制器中处理器方法抛出异常
	 * 使用@ExceptionHandler注解标识异常处理器，异常处理器的返回将作为视图名
	 * 控制器通知
	 * 使用@ControllerAdvice标识控制器通知
	 * 默认情况下，控制器通知中方法应用于所有控制器处理器方法
	 * 可在控制器通知中定义作用于所有处理器方法的异常处理器
	 * 
	 * 拦截器（HandlerInterceptor实现类）
	 * 类似filter，能够对指定处理器方法进行拦截，
	 * preHandle		在处理器方法执行之前执行
	 * postHandle	在处理器方法执行之后执行，视图渲染之前
	 * afterCompletion 在视图渲染完成后执行
	 */
}