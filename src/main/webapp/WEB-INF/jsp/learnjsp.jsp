<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="learnsimpletag" uri="/learnsimpletag" %>
<%@taglib prefix="learnfunctionlib" uri="/learnfunctionlib" %>
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
	jsp页面，创建新servlet对象处理请求；若未发生变化，servlet容器使用已存在的servlet对象处理请求
	
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
	脚本片段<% %>
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
							若设为false，out对象缓冲区填满时会抛出JSP Buffer overflow异常
	isThreadSafe		指定jsp页面是否线程安全？？？
	info					指定jsp信息，设置的信息可以通过servlet 的 getServletInfo方法获取	
	errorPage			指定当前页面发生异常后转发的错误处理页面	
							<%@page errorPage="/WEB-INF/jsp/index.jsp"%>
	isErrorPage		指定当前页面是否为错误处理页面
							若设置为true，会创建隐式exception对象
	contentType		指定响应体MIME类型以及解码响应体使用的编码表
							<%@ page contentType="text/html; charset=utf-8"%>
	pageEncoding	指定解码jsp页面时使用的编码表
							<%@ page pageEncoding="utf-8"%>
	isELIgnored		是否忽略EL表达式
							若设置为true，EL表达式被当做字符串处理
							<%@page isELIgnored="true" %>
	language			指定页面中嵌套的脚本语言类型
	extends			指定servlet父类
	
	相同属性的page指令若属性值冲突会导致异常
	
	include指令用于实现静态引入其他jsp页面
	<%@include file="" %>				
	jsp容器在处理include指令时，会将include指令替换为页面内容，将全部页面内容翻译到servlet service方法中
	
	taglib指令用于引入标签库
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	4.动作
	useBean
	创建指定类对象，并以id作为名称存入域对象中
	<jsp:useBean id="" class="" scope="">
		tag body
	</jsp:useBean>
	id	对象名称
	class 对象全类名
	scope 域对象
	当在域对象中指定的id已存在，不会创建对象
	只有成功创建对象，标签题才会执行
	
	setProperty
	设置域对象中对象的指定属性值
	<jsp:setProperty property="" name="" value=""/>
	name		域对象中对象名称
	property 	对象属性名
	value		对象属性值
	
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
	request			HttpServletRequest对象，表示http请求
	response		HttpServletResponse对象，表示http响应
	session 		HttpSession对象，表示会话对象
	application	ServletContext对象，表示应用上下文
	config			ServletConfig对象，封装servlet初始化参数
	exception		表示异常对象
						只有当前页面为错误处理页面时才会创建exception对象
	out				JspWriter对象，表示字符输出流
						当缓冲区填满时会将数据写入response的输出流中
	page				表示页面对象
	pageContext	表示页面上下文对象
						通过pageContext能够获取其他隐式对象
	pageContext，request，session，application 为域对象
	
	el表达式
	el表达式用于替代脚本表达式，可以获取域对象中的属性值,之后通过out对象输出；也可以通过el表达式直接操作直接常量
	实际通过pageContext的findAttribute方法，使用属性名查找对应属性值
	el表达式可以用于html标签属性中，html标签会被作为模板数据处理
	
	el表达式语法	${expression}，el表达式计算结果可以是任意类型
	当结果为bean，可以通过[]/. 操作符获取bean中属性值
	${object["attribute"]}
	${object.attribute}
	当表达式结果为Map，通过[]/. 操作符获取指定key对应的value
	${map["key"]}
	${map.key}
	当表达式结果为List或数组，通过[]操作符获取指定索引处元素
	${list[index]}
	
	el表达式中可以进行算数，比较，逻辑，三元，empty 等运算
	
	el表达式隐式对象
	由于不建议在jsp页面中使用脚本元素，jsp提供的隐式对象无法使用
	但可以使用el表达式提供的隐式对象
	常用el表达式隐式对象
	pageContext			表示页面上下文对象
								通过pageContext可以获取jsp提供的隐式对象
	pageScope			pageContext 中存储属性的map，key value 都是string类型
	requestScope		request中 存储 属性的map，key value 都是string类型
	sessionScope		session中 存储 属性的map，key value 都是string类型
	applicationScope	servletContext中 存储属性的map，key value 都是string类型
	param					封装所有请求参数的map，key value 都是string类型
								若存在同名请求参数，map中只会存储一个
	paramValues		封装所有请求参数的map，key 是string类型，value 是 string[]类型
	header					封装所有请求头的map，key value 都是string类型
								若存在同名请求头，只会存储一个
	headerValues		封装所有请求头的map，key 是string类型，value 是 string[]类型
	cookie					封装所有cookie的map
								key为cookie中的key
								value为cookie对象
	initParam				封装ServletContext中初始化参数的map，key value 都是string类型
	
	禁用el
	可以通过page指令的isELIgnored属性禁用el
	也可以在部署描述符中禁用el
	<jsp-config>
		<jsp-property-group>
			<url-pattern>*.jsp</url-pattern>
			<el-ignored>true</el-ignored>
		</jsp-property-group>
	</jsp-config>
	
	jstl	jsp标准标签库
	jstl分为五种标签库
	核心标签库
	xml标签库
	国际化标签库
	数据库标签库
	函数标签库
	在jsp页面中使用标签库中标签需要使用taglib指令引入标签库
	
	核心标签库常用标签
	<c:out value="" escapeXml="" default="">
	将指定值写入out对象
	value				指定输出值,支持el表达式
	escapeXml		指定是否对value属性值中特殊字符进行转义
	default				指定默认值，当value属性值为null，会将默认值写入out对象
	
	<c:set>
	将对象添加到域对象中 或 为域对象中对象设置属性
	将对象添加到域对象中
	<c:set var="" scope="" value=""></c:set>
	<c:set var="" scope="">
		value
	</c:set>
	var		指定对象在域对象中的名称
	scope	指定域对象
	value	指定存储的对象
	
	为域对象中对象设置属性
	<c:set target="" property="" value=""></c:set>
	<c:set target="" property="">
		value
	</c:set>
	target		指定域对象中对象名称
	property	指定对象属性名
	value		指定对象属性值
	
	<c:remove var="" scope=""/>
	将对象从域对象map中移除
	var		指定对象在域对象中的名称
	scope	指定域对象
	
	<c:if test="" var="" scope="">
	判断条件是否为真，若为真执行标签体，并将判断结果存入域对象中
	test		指定判断条件
	var		指定判断结果在域对象中名称
	scope	域对象
	
	<c:choose> <c:when> <c:otherwise>
	实现switch功能
	<c:choose>中必须嵌套一个或多个<c:when>
	<c:when>用于定义选项
	<c:otherwise>用于定义默认情况
	 当有多个选项时，只会执行位置最靠上的一个
	 
	 <c:forEach items="" var="" begin="" end="" step="" varStatus="">
	 用于迭代数组 或 实现 Iterable接口的容器
	 会多次执行便签体
	 items			指定迭代对象
	 var				指定元素在域对象中名称
	 begin			指定开始迭代的索引
	 end				指定结束迭代的索引
	 step				指定迭代步长
	 varStatus		指定迭代状态在域对象中名称
	 迭代结束会将域对象中元素删除，迭代后不能继续使用
	 
	 函数标签库
	 函数标签库中提供操作字符串的方法
	 函数库中函数需通过el表达式调用，${fn:方法签名}
	 
	 自定义标签
	 创建自定义标签需要创建简单标签处理器，简单标签处理器需要实现SimpleTag接口或继承SimpleTagSupport类
	 
	 自定义标签的执行过程
	 1.由servlet容器创建简单标签处理器对象
	 2.servlet容器调用对象setJspContext方法，传入pageContext
	   若自定义标签嵌套在其他自定义标签中，servlet容器调用对象setParent方法，传入父标签对象
	 3.若标签存在属性，servlet容器调用属性对应的set方法注入属性值
	 4.若标签存在标签体，servlet容器调用setJspBody方法传入JspFragment对象
	 5.servlet容器调用doTag方法
	 
	 简单标签处理器创建完毕，需使用标签库描述符配置自定义标签
	 之后在jsp中引入标签库就能使用标签库中自定义标签
	 
	 自定义标签属性
	 自定义标签属性 对应 简单标签处理器的成员变量
	 属性值 由 servlet容器通过set方法注入
	 
	 JspFragment
	 JspFragment对象封装标签体
	 invoke方法执行标签体，并将结果输出到指定流中；若invoke参数为null，默认将标签体输出到out对象中
	 
	 自定义函数库
	 函数库中方法必须为公共类中static方法
	 需在标签库描述符中配置自定义函数库
 --%>
</body>
</html>