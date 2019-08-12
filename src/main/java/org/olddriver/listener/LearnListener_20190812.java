package org.olddriver.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LearnListener_20190812
 * Listener笔记
 */
@WebListener
public class LearnListener_20190812 implements 
ServletContextListener, ServletContextAttributeListener,
HttpSessionListener,HttpSessionAttributeListener,
ServletRequestListener,ServletRequestAttributeListener{

	/*
	 * 监听器
	 * 监听器监听事件都继承自EventObject
	 * 监听器分为三类
	 * ServletContext监听器
	 * HttpSession监听器
	 * ServletRequest监听器
	 * 监听器可以使用注解配置，也可以通过部署描述符配置
	 * 
	 * ServletContext监听器
	 * ServletContextListener
	 * 用于监听应用的ServletContext的创建与销毁，监听事件为ServletContextEvent
	 * contextInitialized
	 * 当应用的ServletContext对象创建完毕，Servlet容器会调用所有注册ServletContextListener的contextInitialized方法
	 * contextDestroyed
	 * 当应用的ServletContext对象销毁前，Servlet容器会调用所有注册ServletContextListener的contextDestroyed方法
	 * ServletContextAttributeListener
	 * 用于监听应用的ServletContext中属性变化，监听事件为ServletContextAttributeEvent对象
	 * attributeAdded
	 * 当应用的ServletContext中添加属性，Servlet容器会调用所有注册ServletContextAttributeListener的attributeAdded方法
	 * attributeRemoved
	 * 当应用的ServletContext中移除属性，Servlet容器会调用所有注册ServletContextAttributeListener的attributeRemoved方法
	 * attributeReplaced
	 * 当应用的ServletContext中修改属性，Servlet容器会调用所有注册ServletContextAttributeListener的attributeReplaced
	 * 
	 * HttpSession监听器
	 * HttpSessionListener
	 * 用于监听应用的HttpSession的创建与销毁，监听事件为HttpSessionEvent
	 * sessionCreated
	 * 当应用的HttpSession创建完毕，Servlet容器会调用所有注册的HttpSessionListener的sessionCreated方法
	 * sessionDestroyed
	 * 当应用的HttpSession销毁之前，Servlet容器会调用所有注册的HttpSessionListener的sessionDestroyed方法
	 * HttpSessionAttributeListener
	 * 监听应用的HttpSession中属性变化，监听事件为HttpSessionBindingEvent
	 * attributeAdded
	 * 当应用的HttpSession中添加属性，Servlet容器会调用所有注册的HttpSessionAttributeListener的attributeAdded方法
	 * attributeRemoved
	 * 当应用的HttpSession中移除属性，Servlet容器会调用所有注册的HttpSessionAttributeListener的attributeRemoved方法
	 * attributeReplaced
	 * 当应用的HttpSession中修改属性，Servlet容器会调用所有注册的HttpSessionAttributeListener的attributeReplaced方法
	 * 
	 * ServletRequest监听器
	 * ServletRequestListener
	 * 用于监听应用的ServletRequest创建与销毁，监听事件为ServletRequestEvent
	 * requestInitialized
	 * 当应用的ServletRequest创建完毕，Servlet容器会调用所有注册的ServletRequestListener的requestInitialized方法
	 * requestDestroyed
	 * 当应用的ServletRequest销毁之前，Servlet容器会调用所有注册的ServletRequestListener的requestDestroyed方法
	 * ServletRequestAttributeListener
	 * 用于监听应用的ServletRequest中属性变化，监听事件为ServletRequestAttributeEvent
	 * attributeAdded
	 * 当应用的ServletRequest中添加属性，Servlet容器会调用所有注册的ServletRequestAttributeListener的attributeAdded
	 * attributeRemoved
	 * 当应用的ServletRequest中移除属性，Servlet容器会调用所有注册的ServletRequestAttributeListener的attributeRemoved
	 * attributeReplaced
	 * 当应用的ServletRequest中修改属性，Servlet容器会调用所有注册的ServletRequestAttributeListener的attributeReplaced
	 */
	
	
    /**
     * Default constructor. 
     */
    public LearnListener_20190812() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         System.out.println("ServletContext 中添加的属性名为"+event.getName());
         System.out.println("ServletContext 中添加的属性值为"+event.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	System.out.println("ServletContext 中移除的属性名为"+event.getName());
        System.out.println("ServletContext 中移除的属性值为"+event.getValue());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("ServletContext 销毁");
         System.out.println(sce.getServletContext().getContextPath());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	System.out.println("ServletContext 中修改的属性名为"+event.getName());
        System.out.println("ServletContext 中修改的属性值为"+event.getValue());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContext 创建");
    	System.out.println(sce.getServletContext().getContextPath());
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("HttpSession中添加的属性名为"+event.getName());
		System.out.println("HttpSession中添加的属性值为"+event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSession中移除的属性名为"+event.getName());
		System.out.println("HttpSession中移除的属性值为"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("HttpSession中修改的属性名为"+event.getName());
		System.out.println("HttpSession中修改的属性值为"+event.getValue());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession销毁");
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest中添加的属性名为"+srae.getName());
		System.out.println("ServletRequest中添加的属性值为"+srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest中移除的属性名为"+srae.getName());
		System.out.println("ServletRequest中移除的属性值为"+srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest中修改的属性名为"+srae.getName());
		System.out.println("ServletRequest中修改的属性值为"+srae.getValue());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest创建");
	}
	
}
