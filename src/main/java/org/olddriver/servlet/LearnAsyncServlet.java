package org.olddriver.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.olddriver.listener.LearnAsyncListener;

/**
 * Servlet implementation class LearnAsyncServlet
 * 异步Servlet笔记
 */
@WebServlet(urlPatterns= {"/LearnAsyncServlet"},asyncSupported=true)
public class LearnAsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 *异步Servlet
	 *服务器请求处理线程数量存在上限 
	 *Servlet 会一直占用请求处理线程直到请求结束，若Servlet占用请求处理线程时间过长，
	 *可能会导致服务器无可用请求处理线程
	 *Servlet3.0版本后，添加异步Servlet功能，当Servlet要执行的任务需很长时间，并且用户会
	 *一直等待任务结束，建议使用异步Servlet，使用自定义线程执行任务，不占用请求处理线程
	 *
	 *异步Servlet配置
	 *若使用注解配置，需将asyncSupported元素设置为true
	 *若使用部署描述符配置，在<servlet>中设置<async-supported>元素
	 *
	 *
	 *编写异步Servlet
	 *1.调用ServletRequest的startAsync方法获取AsyncContext对象（异步上下文对象）
	 *在一次请求过程中，AsyncContext对象在第一次调用ServletRequest对象的startAsync方法时创建,
	 *不同请求中会创建新AsyncContext对象
	 *2.调用AsyncContext对象setTimeout方法，设置超时时间，若在指定时间内任务未完成，抛出异常
	 *3.调用AsyncContext对象start方法，传入任务，准备执行任务
	 *4.任务执行完毕调用AsyncContext对象complete方法或dispatch方法
	 *
	 *异步监听器
	 *用于监听异步上下文
	 *异步监听器应该实现AsyncListener接口
	 *异步监听器不需要配置，通过AsyncContext对象的addListener方法注册
	 */
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnAsyncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(5000L);
		asyncContext.addListener(new LearnAsyncListener());
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"------AsyncServlet run");
				asyncContext.complete();
			}
		});
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
