package org.olddriver.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * 动态代理 笔记
 *
 */
public class LearnDynamicProxy{
	/*
	 * 动态代理
	 * 动态代理实现技术分为两种，
	 * 基于接口的动态代理技术（jdk动态代理）
	 * 基于子类的动态代理技术（cglib动态代理）
	 * 
	 * jdk动态代理，要求目标类至少实现一个接口
	 * 通过Proxy类中newProxyInstance方法创建代理对象，newProxyInstance方法具有三个参数
	 * ClassLoader	指定类加载器，一般取目标对象类加载器
	 * Class<?>[] 	指定目标对象实现接口数组
	 *  InvocationHandler	指定调用处理器
	 *  代理对象实现接口数组中的所有接口，代理对象的所有方法调用都会委托给调用处理器的invoke方法，执行invoke方法，invoke方法具有三个参数
	 *  Object		代理对象
	 *  Method	目标对象中的方法对象
	 *  Object[] 	执行方法需要的参数数组
	 *  
	 *  cglib动态代理
	 *  通过Enhancer类中create方法创建代理对象，create方法两个参数
	 *  Class	指定目标类
	 *  Callback	指定方法拦截器，可传入子接口MethodInterceptor
	 *  创建的代理对象是目标对象子类，对代理对象的所有方法调用都会委托给方法拦截器的intercept方法，
	 *  执行intercept方法，intercept方法具有四个参数
	 *  Object	代理对象
	 *  Method	目标对象中的方法对象
	 *  Object[]	执行方法需要的参数数组
	 *  MethodProxy	？？？
	 */
	
	public static void main(String[] args) {
		LearnDynamicProxy learnDynamicProxy = (LearnDynamicProxy) Enhancer.create(LearnDynamicProxy.class,new MethodInterceptor(){

			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before advice");
				Object result = method.invoke(new LearnDynamicProxy(), args);
				System.out.println("after advice");
				return result;
			}
			
		});
		
		System.out.println(learnDynamicProxy.toString());
	}
}
