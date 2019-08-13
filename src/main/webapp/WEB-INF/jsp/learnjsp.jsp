<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>learnjsp</title>
</head>
<body>
<%--
	jsp页面
	jsp页面实质上是一个servlet程序
	jsp页面不能独立运行，需要jsp容器提供运行环境
	通常一个servlet容器，也是一个jsp容器
	
	jsp页面运行过程
	当应用中的jsp页面被第一次访问时，servlet容器会将jsp页面翻译成servlet程序，并将其编译为字节码文件
	之后加载字节码文件，创建servlet对象，使用servlet对象处理请求
	其后再次访问该jsp页面，servlet容器会检测该页面是否发生变化，若发生变化，servlet容器会重建翻译
	jsp页面，创建新servlet对象处理请求；若为发生变化，servlet容器，使用已存在的servlet对象处理请求
	
	jsp页面构成
	jsp页面 包含模板数据 和 语法元素
	模板数据会原样翻译到servlet service方法中，通过out对象写入响应体
	
	jsp语法
	1.jsp注释
	jsp注释不会被翻译到servlet 的 service方法中
	jsp页面中可以包含HTML注释，被当做模板数据处理，html注释会被翻译到servlet service方法中
	通过out对象写入响应体
	2.脚本元素
	脚本元素 包括 脚本片段，脚本表达式，脚本声明
	脚本片段<%%>
	脚本片段中可以嵌套java代码，脚本片段中的java代码会被原样翻译到servlet service方法中执行
	jsp页面中可以定义多个脚本片段，多个脚本片段中的内容可以相互调用
	单独脚本片段中的代码可以不完整，但多个脚本片段中的代码必须完整
	脚本表达式<%= %>
	脚本表达式用于输出表达式值，脚本表达式中的表达式会被翻译到servlet service方法中，表达式
	结果会通过out对象写入响应体
	脚本声明<%! %>
	脚本声明中嵌套java代码，脚本声明中的java代码会被原样翻译到servlet类中，service方法之外
	不建议在jsp页面中使用脚本元素
	可以在部署描述符中禁用jsp 脚本元素，若禁用后再访问具有脚本元素的页面，会发生异常
	3.指令
	指令为jsp引擎设计
	分为page指令，include指令，taglib指令三种
	page指令用于定义页面属性
	<%@page attribute="value"%>
	常用属性
	import				在servlet中导入指定包中的类
							<%@page import="java.util.Date"%>
	session				指定是否创建隐式session对象，默认为true
	buffer				指定out对象的缓冲区大小,
							以kb为单位，
							none表示无缓冲
							<%@page buffer="8kb" %>
	autoFlush			指定out对象缓冲区填满后，是否刷新缓冲区将数据写入输出流中
							若设为false，out对象缓冲区填满时会JSP Buffer overflow异常
	isThreadSafe		指定jsp页面是否线程安全？？？
	info					指定jsp信息，设置的信息可以通过servlet 的 getServletInfo方法获取	
	errorPage			指定当前页面发生异常后转发的错误处理页面	
							<%@page errorPage="/WEB-INF/jsp/index.jsp"%>
	isErrorPage		指定当前页面是否为错误处理页面
							若设置为true，会创建隐式exception对象
	contentType		指定响应体MIME类型以及解码响应体使用的编码表
							<%@ page contentType="text/html; charset=utf-8"%>
	pageEncoding	指定解码jsp文件时使用的编码表
							<%@ page pageEncoding="utf-8"%>
	isELIgnored		是否忽略EL表达式
							若设置为true，EL表达式被当做字符串处理
							<%@page isELIgnored="true" %>
	language			指定页面中嵌套的脚本语言类型
	extends			指定servlet父类
	
	相同属性的page指令若属性值冲突抛异常
	
	include指令用于实现静态引入其他jsp页面
	<%@include file="" %>				
	jsp容器在处理include指令时，会将include指令替换为页面内容
	4.动作
	useBean
	创建指定类对象，并以id作为属性名存入域对象中
	<jsp:useBean id="" class="" scope="">
		tag body
	</jsp:useBean>
	id	对象属性名
	class 对象全类名
	scope 域对象
	当在域对象中指定的id已存在，不会创建对象
	只有成功创建对象，标签题才会执行
	
	setProperty
	设置域对象中对象的指定属性值
	<jsp:setProperty property="" name="" value=""/>
	name		域对象中对象名称
	property 	对象属性名
	value		设置的属性值
	
	getProperty
	获取域对象中对象属性值
	<jsp:getProperty property="" name=""/>
	name		域对象中对象名
	property	对象属性名
	
	include
	动态引入jsp页面
	<jsp:include page=""></jsp:include>
	page		引入jsp页面路径
	动态引入与静态引入实现方式不同
	静态引入 将include指令替换为页面内容，将页面内容翻译到servlet service方法中
	动态引入 在servlet service方法中通过include方法实现引入
	
	forward
	实现请求转发
	<jsp:forward page="">
		<jsp:param value="" name=""/>
	</jsp:forward>
	page		指定转发的路径
	
	param
	为请求转发中的url添加请求参数
	<jsp:param value="" name=""/>
	name		请求参数名
	value		请求参数值
	
	隐式对象
	jsp页面对应的servlet service方法中定义了多个局部变量
	在jsp页面中能够直接使用这些变量
	request			表示http请求
	response		表示http响应
	session 		表示会话对象
	application	表示ServletContext对象
	config			表示ServletConfig对象
	exception		表示异常对象
	out				表示字符输出流对象
						类似具有缓冲区的PrintWriter
	page				表示页面对象
	pageContext	表示页面上下文对象
						通过pageContext能够获取其他隐式对象
	pageContext，request，session，application 为域对象
 --%>
</body>
</html>