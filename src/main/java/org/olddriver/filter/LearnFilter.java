package org.olddriver.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LearnFilter
 * Filter笔记
 */
@WebFilter("/LearnFilter")
public class LearnFilter implements Filter {

	/*
	 * 过滤器
	 * Filter对request，response进行拦截
	 * 能够在Servlet容器执行Servlet对象service方法之前对request，response进行预处理
	 * Filter配置
	 * Filter 可以通过注解配置，也能通过部署描述符配置
	 * 当需要控制Filter的触发顺序，只能通过部署描述符配置
	 * Filter接口
	 * 所有过滤器应该直接或间接实现Filter接口
	 * Filter生命周期
	 * 服务器启动，Servlet容器就会创建应用的所有Filter对象，之后调用Filter对象的init方法进行初始化
	 * 初始化完毕，Filter对象会在内存中存储，准备拦截指定请求
	 * 当服务器关闭，Servlet容器会调用Filter对象destroy方法，销毁Filter
	 * init
	 * 用于对Filter进行初始化，Servlet容器创建Filter对象后，就会调用Filter对象的init方法进行初始化
	 * init方法会传入FilterConfig对象，其中封装Filter的初始化参数
	 * init方法在Filter生命周期中仅执行一次
	 * doFilter
	 * 当用户请求的Servlet关联一个FilterChain，在Servlet容器执行service方法之前
	 * 会先执行某个Filter的doFilter方法，在doFilter方法结尾应该调用FilterChain的doFilter方法，
	 * 触发过滤器链上下一个过滤器的doFilter，当所有过滤器doFilter方法都被执行完，FilterChain的doFilter方法
	 * 就会触发service方法处理请求
	 * destroy
	 * 当服务器关闭，Servlet容器会调用Filter的destroy方法销毁Filter
	 * destroy方法仅在Filter生命周期中执行一次
	 * 
	 * Filter线程不安全
	 * 通常一个Filter类对应一个Filter对象，该对象被应用的所有用户共享，线程不安全
	 * Filter实现线程安全
	 * 在Filter中定义成员变量，存储单一线程线程池
	 * 在doFilter方法中向线程池中提交任务，当Filter销毁应该在destroy方法中关闭线程池
	 * 
	 * Filter触发顺序
	 * 若使用注解配置Filter，Filter触发顺序不可控
	 * 若要控制Filter触发顺序，必须使用部署描述符配置Filter，Filter的触发顺序与filter-mapping
	 * 定义顺序一致
	 */
	
	
    /**
     * Default constructor. 
     */
    public LearnFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
