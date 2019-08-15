package org.olddriver.spring;


/**
 * 
 * spring 笔记
 * spring 中文文档仓库	DocsHome/spring-docs
 * 									wangjingjing/spring-framework-reference
 * 								  
 */
public class LearnSpring {
	/*
	 * spring
	 * spring用于创建java企业级应用，目的在于简化java开发
	 * 为了简化java开发，spring采用四种策略
	 * 1.基于pojo（Plain Old Java object 简单老式java对象）最小侵入式编程
	 * 某些传统框架 要求 程序中的类必须继承指定类 或 实现指定接口才能获取框架功能
	 * spring不要求类继承任何类 或 实现任何接口
	 * 2.通过依赖注入实现低耦合
	 * 耦合性 指 对象间的依赖关系
	 * 一个有意义的应用一定通过多个类相互协作实现业务逻辑
	 * 传统项目中，对象需自己管理与其协作的对象，耦合性高，难以复用
	 * 依赖注入 指 对象的依赖关系由spring容器在创建对象时设置，对象不需自行创建依赖关系
	 * 3.通过切面实现声明式编程
	 * 应用中往往存在在各个组件中都会使用的功能，该功能称为横切关注点
	 * 面向切面指将横切关注点抽象为独立功能模块，再将该模块以某种方式（如声明）应用于各个组件上
	 * 4.通过模板消除样板式代码
	 * 
	 * spring容器
	 * spring框架的核心，spring容器负责创建，装配，管理bean的生命周期
	 * 
	 * spring容器分类	
	 * BeanFactory（bean工厂），ApplicationContext（应用上下文）
	 * 
	 * BeanFactory
	 * BeanFactory提供容器基本功能
	 * 
	 * ApplicationContext
	 * ApplicationContext是BeanFactory子接口，对BeanFactory的拓展
	 * spring提供多种应用上下文的实现，多个实现类之间仅仅加载元数据的方式不同
	 * spring配置元数据可以通过xml，注解，java代码的方式
	 * 当通过xml方式配置元数据，可以使用ClassPathXmlApplicationContext 或 FileSystemXmlApplicationContext
	 * 类型的应用上下文
	 * ClassPathXmlApplicationContext	用于读取类路径下（classes目录中）的元数据
	 * FileSystemXmlApplicationContext	用于读取文件系统中的元数据
	 * 当使用注解方式配置元数据，可以使用AnnotationConfigApplicationContext类型的应用上下文
	 * 
	 * spring容器中bean的生命周期
	 * 容器创建对象过程
	 * 1.容器创建bean对象
	 * 2.对bean进行装配
	 * 3.若bean实现BeanNameAware接口，容器调用bean的setBeanName方法，传入bean的id
	 * 4.若bean实现BeanFactoryAware接口，容器调用bean的setBeanFactory方法，传入BeanFactory对象
	 * 5.若bean实现ApplicationContextAware接口，容器调用bean的setApplicationContext方法，传入ApplicationContext对象
	 * 6.容器调用容器中所有BeanPostProcessor对象（Bean后置处理器）的postProcessBeforeInitialization方法，当前对象除外
	 * 7.若bean实现InitializingBean接口，容器调用bean的afterPropertiesSet方法
	 * 8.容器调用bean中自定义的初始化方法（必须通过xml方式配置）
	 * 9.容器调用容器中所有BeanPostProcessor对象的postProcessAfterInitialization方法
	 * bean就此完成初始化
	 * 容器销毁对象过程
	 * 1.若bean实现DisposableBean接口，容器调用bean的destroy方法
	 * 2.容器调用bean中自定义的销毁方法（必须通过xml方式配置）
	 * 
	 * spring框架目录结构
	 * libs目录中存放spring jar文件
	 * 一个spring模块对应三个jar文件，包括字节码，源文件，说明文档
	 * 
	 * spring配置bean方式
	 * 1.通过组件扫描，自动装配实现自动配置bean
	 * 自动配置bean必须通过注解实现
	 * 在spring配置类上使用@ComponentScan开启组件扫描并指定基础包，
	 * spring容器会扫描基础包及其子包中的组件类，创建组件对象加入spring容器
	 * 相关注解
	 * @ComponentScan			开启组件扫描并指定基础包。若未指定基础包，将配置类所在的包作为基础包
	 * basePackages元素 			指定基础包路径
	 * basePackageClasses元素	基础包中包含的类，该类所在的包就是基础包，更加安全
	 * @Component					标识当前类为组件类，value元素指定bean id。若未指定bean id，已首字母小写的类名作为bean id
	 * @Autowired						用于实现自动装配，spring容器会从容器中寻找类型相同的bean进行注入
	 * 											@Autowired可用于构造器，方法，成员变量上
	 * 											@Autowired用于方法上，容器会调用该方法实现装配
	 * 											@Autowired用于构造器上，使用指定构造器创建对象
	 * 2.通过java 方法配置bean
	 * 当使用第三方类库，无法在类上添加注解，需要在方法中配置bean
	 * 在配置类中创建方法，方法返回bean对象。使用@Bean注解修饰方法，在方法中通过构造器或set方法
	 * 注入依赖
	 * @Bean			用于将方法返回值加入spring容器管理
	 * 	name元素		指定bean在容器中的id，若不指定bean的id，默认以方法名作为id
	 * 3.通过xml 配置bean
	 * 
	 * 
	 */
}
