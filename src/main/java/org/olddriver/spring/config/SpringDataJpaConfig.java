package org.olddriver.spring.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.olddriver.spring.repository.AdminRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//启用事务管理器
@Configuration
@EnableTransactionManagement  
@EnableJpaRepositories(basePackageClasses= {AdminRepository.class},
						entityManagerFactoryRef="entityManagerFactory",
						transactionManagerRef="transactionManager")
public class SpringDataJpaConfig {
	
	@Bean("dataSource")
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
	
	/**
	 * 配置jpa厂商适配器
	 * @return
	 */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        //设置数据库类型（可使用org.springframework.orm.jpa.vendor包下的Database枚举类）
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        //设置打印sql语句
        jpaVendorAdapter.setShowSql(true);
        //设置不生成ddl语句
        jpaVendorAdapter.setGenerateDdl(false);
        //设置hibernate方言
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return jpaVendorAdapter;
    }
    
    /**
     * 配置实体管理器工厂
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
             DataSource dataSource,  JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        //注入数据源
        emfb.setDataSource(dataSource);
        //注入jpa厂商适配器
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        //设置扫描基本包
        emfb.setPackagesToScan("org.olddriver.spring.bean");
        return emfb;
    }
    
    /**
     * 配置jpa事务管理器
     * @param emf
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        //配置实体管理器工厂
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
