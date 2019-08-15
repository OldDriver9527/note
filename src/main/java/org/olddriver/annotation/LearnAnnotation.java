package org.olddriver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * annotation笔记
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LearnAnnotation {
	/*
	 * 注解 
	 * 注解用于配置元数据，元数据指用于描述数据属性的数据
	 * 通过注解能够在源码中添加元数据，运行时再通过注解处理器获取元数据
	 * 
	 * jdk5中提供注解
	 * @Override
	 * 表示当前方法覆盖父类中方法
	 * @Deprecated
	 * 表示当前成员已过时，不建议使用
	 * @SuppressWarnings
	 * 用于抑制编译器不当警告
	 * 
	 * 声明注解
	 * 声明注解 与 声明接口类似
	 * 使用@interface关键字声明注解，注解编译后生成的仍是字节码文件，基本声明格式
	 * modifier @interface AnnotationName{
	 * 		AnnotationElement
	 * }
	 * 声明注解时需要使用一些元注解
	 * @Target
	 * 指定注解使用位置，value元素类型为ElementType[]，value可取值为
	 * ElementType.TYPE							表示注解使用于类，枚举，接口上
	 * ElementType.FIELD						表示注解使用在成员变量上
	 * ElementType.METHOD					表示注解使用在成员方法上
	 * ElementType.PARAMETER				表示注解使用在方法参数上
	 * ElementType.CONSTRUCTOR			表示注解使用在构造器上
	 * ElementType.LOCAL_VARIABLE		表示注解使用在局部变量上
	 * ElementType.ANNOTATION_TYPE	表示注解使用在注解上
	 * ElementType.PACKAGE					表示注解使用在包上
	 * 
	 * @Retention
	 * 指定注解生命周期，value元素类型为RetentionPolicy，value可取值为
	 * RetentionPolicy.SOURCE	
	 * 注解仅存在于源文件中，字节码文件中不存在
	 * RetentionPolicy.CLASS
	 * 注解存在于字节码文件中，但运行时不存在
	 * RetentionPolicy.RUNTIME
	 * 注解一直保留，运行时可通过反射获取
	 * 
	 * @Documented
	 * 指定注解是否被包含进javadoc文档
	 * javadoc文档中默认不包含注解，若注解被@Documented修饰，在生成的文档中
	 * 声明信息中就会包含注解
	 * 
	 * @Inherited
	 * 指定注解能否被继承
	 * 若注解被@Inherited修饰，在父类上使用该注解，子类会继承该注解
	 * 
	 * 声明注解元素
	 * 声明注解元素 与 声明接口方法类似
	 * 方法名 对应 注解元素名
	 * 方法返回值 对应 注解类型
	 * 方法参数列表为空
	 * 在参数列表后可以使用default指定注解元素默认值
	 * 
	 * 注解之间不支持继承
	 */
	String value();
}
