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
	 * 面向切面 指 将程序中的横切关注点模块化，以切面的形式将其 应用于程序各处
	 * 
	 * aop术语
	 * 切面（Aspect）
	 * 表示模块化的横切关注点，切面中包括通知，切点
	 * 连接点（Join point）
	 * 程序执行过程中的某个特定的时间点
	 * Spring AOP中，连接点代表方法执行的时间点
	 * 通知（Advice）
	 * 切面动作
	 * 切点（Pointcut）
	 * 匹配连接点的断言，
	 * 当连接点匹配切点，就会在连接点前后执行通知
	 * 引入（Introduction）？？？？
	 * 目标对象（Target object）？？？
	 * 被一个或者多个切面所通知的对象
	 * AOP代理（AOP proxy）？？？
	 * AOP框架创建的对象
	 * 织入（Weaving）？？？
	 * 
	 * Spring AOP通知分类
	 * 前置通知（Before advice）
	 * 在连接点之前运行的通知
	 * 后置返回通知（After returning advice）
	 * 在连接点成后执行的通知，且连接点正常完成
	 * 后置异常通知（After throwing advice）
	 * 在连接点后执行的通知，且连接点非正常完成
	 * 后置通知（After （finally） advice）
	 * 在连接点后执行的通知，总会执行
	 * 环绕通知（Around Advice）
	 * 环绕连接点的通知
	 * 
	 */
}
