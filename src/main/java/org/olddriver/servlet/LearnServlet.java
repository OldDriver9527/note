package org.olddriver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearnServlet
 * Servlet笔记
 */
@WebServlet("/LearnServlet")
public class LearnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 *servelt/jsp应用
	 *Servlet 是运行在web服务器的java程序
	 *jsp页面会被web服务器翻译成Servlet程序
	 *servlet/jsp应用中会包含多个Servlet程序，jsp页面
	 *servlet/jsp应用不能独立运行，需要servlet容器提供运行环境
	 *tomcat服务器的核心组件为servlet容器，代号catalina，在server.xml 中server元素表示Catalina servlet容器
	 *
	 *http协议
	 *http协议称为超文本传输协议，用于web服务器与web浏览器之间进行数据传输
	 *http协议url格式
	 *protocol://domain[:port][/context][/resource][?query string]
	 *protocol://ipaddress[:port][/context][/resource][?query string]
	 *protocol
	 *表示协议名
	 *domain
	 *表示域名，多个域名能够对应同一个ip，通过ping命令能够获取域名对应的ip
	 *context
	 *表示上下文，访问的服务器中应用名称，为空默认访问服务器的默认应用
	 *resource
	 *表示资源路径，访问的应用中的资源路径，为空默认访问应用中的默认资源
	 *query tring
	 *表示查询字符串，其中封装请求参数，请求参数格式为key=value，多个请求参数使用&连接
	 *http请求
	 *一个完整的http请求报文，包括请求行，请求头，请求体
	 *请求行 中 包括 请求方法 请求uri 协议及版本
	 *请求方法共七种，get/post最为常用
	 *请求头 封装请求相关信息
	 *请求体 当请求方法为post时，用于封装请求参数
	 *			 请求头与请求体之间存在一空行
	 *http响应
	 *一个完成的http响应报文包括 响应行，响应头，响应体
	 *响应行 包括 协议及版本 响应状态码 描述
	 *			 常用状态码 如 200 ，405...
	 *响应头 用于封装响应的相关信息
	 *响应体 用于封装响应正文，默认响应正文为html文档
	 *
	 *Servlet接口
	 *所有Servlet类都应该直接或间接实现Servlet接口
	 *Servlet容器负责加载Servlet类，创建Servlet对象，对Servlet对象进行管理
	 *通常一个Servlet类对应一个Servlet对象
	 *Servlet对象的生命周期
	 *当应用中的Servlet资源被第一次访问，Servlet容器会加载Servlet类，创建Servlet对象
	 *之后调用Servlet对象的init方法进行初始化，init方法会传入ServletConfig对象
	 *该对象中封装Servlet的初始化参数
	 *初始化完毕，Servlet容器会调用Servlet对象的service方法，处理请求，将响应封装在response
	 *对象中，service方法结束，请求结束，服务器将响应回送浏览器
	 *之后Servlet对象会存储在内存中，等待处理下一次请求
	 *当服务器关闭，Servlet容器会调用Servlet对象的destroy方法销毁Servlet对象
	 *Servlet接口中的方法
	 *init
	 *对Servlet对象进行初始化，当Servlet容器创建完Servlet对象，会调用对象的init方法进行初始化
	 *init方法会传入ServletConfig对象，其中封装Servlet的初始化参数
	 *init方法在Servlet生命周期中仅会调用一次
	 *service
	 *用于处理请求
	 *每当用户请求应用中的某个Servlet资源，该Servlet对象的service方法就会被调用
	 *service方法在Servlet生命周期中会执行多次
	 *destroy
	 *用于销毁Servlet
	 *当服务器关闭Servlet容器就会调用destroy方法销毁Servlet
	 *destroy方法仅在Servlet生命周期中执行一次
	 *getServletConfig
	 *获取init方法传入的ServletConfig对象
	 *与生命周期无关的方法
	 *getServletInfo
	 *获取Servlet信息
	 *
	 *Servlet线程不安全
	 *Servlet类通常只对应一个Servlet对象，该对象被应用的所有用户共享，不建议在Servlet中
	 *使用成员变量
	 *
	 *Servlet配置
	 *Servlet3.0版本之前，配置Servlet需要部署描述符
	 *Servlet3.0版本之后，建议使用注解配置Servlet
	 *@WebServlet 
	 *用于配置Servlet，当在部署描述符中未设置metadata-complete属性
	 *Servlet容器在读取部署描述符后，会检测所有类，当发现具有指定注解的类时，
	 *会将其注册为Servlet
	 *
	 *Servlet应用目录结构
	 *在项目根目录下 存在 WEB-INF目录
	 *该目录中存在classes目录，lib目录，web.xml
	 *calsses存储字节码文件
	 *lib存储依赖
	 *web.xml为部署描述符
	 *
	 *ServletRequest
	 *表示客户端请求
	 * ServletRequest 中封装请求相关信息
	 * 请求参数的中文乱码
	 * ServletRequest对象默认使用ISO-8859-1进行编码，当请求参数中含有中文，通过request对象
	 * 获取可能会出现乱码
	 * get请求
	 * 当请求参数中包含中文，前端采用utf-8进行编码
	 * 通过ServletRequest getParameter方法获取，会使用ISO-8859-1解码导致乱码
	 * 需要手动使用ISO-8859-1进行编码，在使用utf-8解码
	 * post请求
	 * 当请求参数中含有中文，只需修改ServletRequest使用的编码表后，就可通过getParameter
	 * 方法获取
	 * 
	 * ServletResponse
	 * 表示服务器响应
	 * ServletResponse 中封装响应相关信息
	 * ServletResponse屏蔽了服务器向浏览器回送响应的复杂过程
	 * ServletResponse 默认使用 ISO-8859-1 编码
	 * 当向浏览器回送中文，可能会发生乱码
	 * 向浏览器回送中文时 要修改ServletResponse使用的编码表，并设置contentType响应头
	 * 两者指定的编码表一致
	 * 
	 * ServletConfig
	 * 封装Servlet的初始化参数
	 * 接口中方法
	 * getServletName
	 * 获取Servlet名称
	 * getServletContext
	 * 获取应用上下文
	 * getInitParameter
	 * 根据名称获取Servlet初始化参数
	 * getInitParameterNames
	 * 获取封装所有初始化参数名称的枚举对象
	 * 
	 * ServletContext
	 * 表示应用上下文
	 * 对象中封装应用的相关信息
	 * 
	 * GenericServlet
	 * 通用Servlet
	 * 实现Servlet，ServletConfig接口的抽象类
	 * 对接口中大部分方法进行实现，除了service方法
	 * GenericServlet 中存在两个init方法
	 * 以ServletConfig 为参数的init方法
	 * 空参init方法
	 * 在有参init方法中，将ServletConfig 赋值给成员变量，之后调用无参init方法
	 * GenericServlet 子类中仅需override 无参init方法即可
	 * 
	 * HttpServlet
	 * 用于处理http请求的Servlet
	 * HttpServlet 是 GenericServlet 子类，对service方法进行override
	 * HttpServlet 中存在两个service方法
	 * 一个以ServletRequest，ServletResponse 为参数
	 * 一个以HttpServletRequest，HttpServletResponse为参数
	 * 在原始service方法中，将request，response 转型为http类型后，调用新增service方法
	 * 在新增service方法中，会根据请求方法，决定调用哪个方法处理请求
	 * HttpServlet 子类仅需override doGet/doPost方法
	 * 使用HttpServlet 就会使用到HttpServletRequest，HttpServletResponse
	 * HttpServletRequest
	 * 表示http请求
	 * HttpServletResponse
	 * 表示http响应
	 * 
	 * 部署描述符
	 * 部署描述符常命名为web.xml
	 * Servlet3.0版本之前，要使用部署描述符配置Servlet，Filter等
	 * Servlet3.0版本之后，建议使用注解配置，部署描述符可以省略
	 * 若一个Servlet 既使用部署描述符配置，又使用注解配置，以部署描述符中的配置为准
	 * tomcat 的conf目录中存在部署描述符，其中配置会应用到服务器中各个应用
	 * 
	 * 会话管理
	 * 会话
	 * 用户使用同一个浏览器进程 与 服务器进行交互的过程称为一个会话
	 * 浏览器进程关闭，会话结束
	 * 会话管理技术
	 * cookie
	 * session
	 * url重写
	 * 隐藏域
	 * 
	 * cookie
	 * cookie是很小的文本片段，可以存储在客户端，通过cookie可以实现页面之间
	 * 传值
	 * 当浏览器访问应用中某个资源，服务器想保存某些会话数据，可以将会话数据以key，value
	 * 形式存储到cookie 中，再将cookie添加到response中，以响应头的形式回送浏览器
	 * 之后浏览器再访问该服务器，就会携带cookie方法，服务器可以冲cookie中获取会话数据
	 * 浏览器 默认为每个服务器存储20个cookie
	 * 删除cookie可以在服务器端创建同名cookie，将cookie有效期设为0
	 * 若cookie有效期为正数，cookie就会存储在磁盘中，关闭浏览器仍会存在
	 * 
	 * session
	 * 服务器创建存储会话数据的对象
	 * 服务器会为每个浏览器进程创建一个session，将会话数据存储在session中
	 * 当请求结束，将session id回送浏览器
	 * 之后浏览器再次访问时，通过session id获取session
	 * 不建议在session总存储较大数据，消耗服务器内存
	 * 
	 * url重写
	 * 当浏览器禁用cookie，session id不能以cookie形式回送浏览器
	 * 此种情况下仍想用session管理会话数据，可以使用url重写
	 * 在url中添加session id
	 * 
	 * 请求重定向 
	 * 请求转发
	 * 请求转发称为服务器跳转
	 * 浏览器发送一次请求，在服务器端实现跳转
	 * 请求重定向称为浏览器跳转
	 * 浏览器发送一次请求后，服务器完成响应，响应状态码为302,并设置Location响应头
	 * 指定重定向url
	 * 转发url以/开头，/表示项目根目录
	 * 重定向url以/开头，/表示服务器根目录
	 */
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get请求获取中文请求参数
		//System.out.println(new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8"));
		//post请求获取中文请求参数
		//request.setCharacterEncoding("utf-8");
		//System.out.println(request.getParameter("name"));
		//response.getOutputStream().write("hello".getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
