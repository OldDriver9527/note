package org.olddriver.spring.config;

import java.beans.PropertyVetoException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration
public class DataSourceConfig {
	
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
			comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("root");
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
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("root");
        
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
