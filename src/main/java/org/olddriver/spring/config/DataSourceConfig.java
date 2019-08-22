package org.olddriver.spring.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration
@PropertySource(value= {"classpath:/org/olddriver/datasource/jdbc.properties"})
public class DataSourceConfig {
	
	@Value(value="${jdbc.driver}")
	private String driverClass;
	
	@Value(value="${jdbc.url}")
	private String jdbcUrl;
	
	@Value(value="${jdbc.user}")
	private String userName;
	
	@Value(value="${jdbc.password}")
	private String password;
	
	/*
	 * 数据源	DataSource
	 * 数据源用于提供数据库链接，是DriverManager的替代项，数据源是获取数据库链接的首选
	 * 数据源的实现可分为三类，其中一类为连接池实现
	 */
	
	@Bean("dataSource")
    @Profile("development4c3p0")
    public DataSource comboPooledDataSource() {
		/*
		 * c3p0连接池
		 */
		ComboPooledDataSource comboPooledDataSource = null;
		try {
			System.out.println("c3p0连接池");
			comboPooledDataSource = 
					new com.mchange.v2.c3p0.ComboPooledDataSource();
			comboPooledDataSource.setDriverClass(driverClass);
			comboPooledDataSource.setJdbcUrl(jdbcUrl);
			comboPooledDataSource.setUser(userName);
			comboPooledDataSource.setPassword(password);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return comboPooledDataSource;
    }
	
	@Bean("dataSource")
    @Profile("development4Druid")
    public DataSource druidDataSource() {
		/*
		 * druid 连接池
		 */
		System.out.println("druid 连接池");
		DruidDataSource datasource = new DruidDataSource();
		datasource.setDriverClassName(driverClass);
        datasource.setUrl(jdbcUrl);
        datasource.setUsername(userName);
        datasource.setPassword(password);
        
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
        return datasource;
    }
	
	@Bean("dataSource")
    @Profile("development4jndi")
	public DataSource jndiDataSource() {
		/*
		 * JNDI java 命名和目录接口
		 * java提供的一组接口规范，统一了使用命名服务，目录服务的方式
		 * JNDI数据源	数据源由服务器创建，管理
		 * 
		 * 由于JndiObjectFactoryBean 会导致方法返回FactoryBean类型对象
		 * 所以不使用JndiObjectFactoryBean进行jndi查找
		 */
	     try {
	    	 Context ctx = new InitialContext();
			 return (DataSource) ctx.lookup("java:comp/env/jndi/datasource");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
