package org.olddriver.spring;
/**
 * 
 * aop 笔记
 *
 */
public class LearnAop {
	/*
	 * aop（Aspect-oriented Programming）
	 * 面向切面 是对 oop的补充
	 * 面向切面 指 将程序中的横切关注点模块化，以切面的形式将其 应用于需要的位置
	 * 
	 * aop术语
	 * 切面---Aspect
	 * 表示模块化的横切关注点，切面中包括通知，切点
	 * 连接点---Join point ***********
	 * 程序中能够插入通知的位置，可以是方法，成员变量等
	 * spring aop通过动态代理实现，spring中连接点只能表示 spring容器中bean的方法
	 * 通知---Advice
	 * 切面动作
	 * 切点---Pointcut
	 * 匹配连接点的断言，
	 * 当连接点匹配切点，就会在连接点前后插入通知
	 * 引入---Introduction
	 * 为被通知对象添加额外方法
	 * 目标对象---Target object
	 * 被一个或者多个切面所通知的对象
	 * AOP代理---AOP proxy
	 * AOP框架创建的对象
	 * 织入---Weaving
	 * 
	 * Spring AOP通知分类
	 * 前置通知（Before advice）
	 * 在连接点之前运行的通知
	 * 后置返回通知（After returning advice）
	 * 在连接点后执行的通知，且连接点正常完成
	 * 后置异常通知（After throwing advice）
	 * 在连接点后执行的通知，且连接点非正常完成
	 * 后置通知（After （finally） advice）
	 * 在连接点后执行的通知，总会执行
	 * 环绕通知（Around Advice）
	 * 环绕连接点的通知
	 * 
	 * aop注解实现
	 * 1.开启对AspectJ注解支持
	 * spring aop中使用AspectJ的注解，通过注解实现aop时要开启对AspectJ注解支持，使用可以通过注解或xml方式配置
	 * 在配置类上使用@EnableAspectJAutoProxy 开启对AspectJ注解支持
	 * 在xml配置文件中，使用<aop:aspectj-autoproxy/>元素 开启对AspectJ注解支持
	 * 2.声明切面
	 * 使用@Aspect注解将 组件 标识为切面
	 * 3.声明切点
	 * 切点包括 切点签名 和 切点表达式，
	 * 切点签名可以通过方法提供，
	 * 切点表达式可以使用@Pointcut注解在方法上定义
	 * 切点表达式 语法
	 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?
	 * 				name-pattern(param-pattern)throws-pattern?)
	 * execution		切点标识符，用于匹配连接点
	 * modifiers-pattern	修饰符模式，用于指定连接点修饰符，可选
	 * ret-type-pattern	返回类型模式，用于指定连接点返回值类型，*表示任意类型
	 * declaring-type-pattern	声明类型模式，用于指定连接点所在包名，类名
	 * 										包名，类名.连接，可选，*表示任意包，任意类
	 * 										包名，类名中可以包含* ？？？？
	 * name-pattern		名称模式，用于指定连接点名称，*表示任意名称
	 * 								名称中可以包含*
	 * param-pattern		参数模式，用于指定连接点参数列表，..表示任意个数，任意类型参数
	 * 								*表示任意类型单个参数
	 * 4.声明通知
	 * 使用@Before注解 标识前置通知
	 * 使用@AfterReturning注解 标识后置返回通知
	 * 使用@AfterThrowing注解 标识后置异常通知
	 * 使用@After注解 标识后置通知
	 * 使用@Around注解 标识环绕通知，环绕通知第一个参数必须是ProceedingJoinPoint类型，表示连接点
	 * 
	 * Spring AOP基于代理实现
	 * 容器创建bean对象时，会在某个BeanPostProcessor的方法中进行判断，若需要在bean的方法前后
	 * 插入通知，会生成bean的代理对象加入容器
	 */
}
