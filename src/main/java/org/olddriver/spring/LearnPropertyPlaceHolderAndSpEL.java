package org.olddriver.spring;
/**
 * 
 * 属性占位符，SpEL 笔记
 *
 */
public class LearnPropertyPlaceHolderAndSpEL {
	/*
	 * 通过属性占位符，spring表达式语言
	 * 为bean中基本类型数据注入值，防止硬编码
	 * 
	 * 属性占位符 ${attributeName}
	 * Environment 集成在spring容器中的对象，其中存储当前应用的环境信息，如系统环境变量，jvm的属性等
	 * 在配置类上通过@PropertySource注解，将指定properties文件对应的PropertySource对象加入Environment中
	 * 属性占位符会被解析为Environment中存储的属性值
	 * 进行依赖注入时，可以使用@Value() 注解配合属性占位符使用
	 * 
	 * SpEL
	 * SpEL 类似jsp el表达式，能够从spring容器中获取bean 或 操作直接常量
	 * 
	 * SpEL语法	#{expression string}
	 * #{bean id}		通过id引用bean
	 * 						通过[]/.操作符能够获取bean中属性值及调用bean中方法
	 * 						当bean 类型为list 数组，通过[]操作符 获取指定索引出元素
	 * 						当bean 类型为map，通过[]或.操作符 获取指定key的value ？？？？//待测试
	 * #{T(fully-qualified-name)}		通过类全名引用Class对象
	 * 												通过.操作符调用类中静态成员
	 * 	
	 * SpEL中支持算数，比较，逻辑等运算
	 */
}