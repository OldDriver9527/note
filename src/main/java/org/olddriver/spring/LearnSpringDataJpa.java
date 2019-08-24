package org.olddriver.spring;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * spring data jpa 笔记
 * 中文文档仓库 ityouknow/spring-data-jpa-reference-documentation
 */
public class LearnSpringDataJpa {
	/*
	 * Spring Data JPA 是spring 在持久层的应用
	 * Spring Data JPA 对JPA规范的封装，具体实现由orm厂商提供，如hibernate jpa
	 * 使用Spring Data JPA只需从一组接口中选择一个进行扩展，不需编写接口实现
	 * 
	 * Spring Data JPA 核心接口
	 * Repository接口
	 * Repository 是 spring data common中顶层接口，以操作实体类，实体类主键类型为泛型参数
	 * 接口中无内容，属于标记接口
	 * 
	 * CrudRepository接口
	 * Repository 子接口，提供通用CRUD功能
	 * save(S entity)		保存实体类
	 * saveAll(Iterable<S> entities)	批量保存
	 * findById(ID id)	根据主键查询实体
	 * existsById(ID id)		判断指定id实体是否存在
	 * findAll()		查询全部实体
	 * findAllById(Iterable<ID> ids)		批量查询
	 * count()	查询总数
	 * deleteById(ID id)	根据指定id删除实体
	 * delete(T entity)		根据指定实体删除实体
	 * deleteAll(Iterable<? extends T> entities)	批量删除指定实体
	 * deleteAll()		删除所有实体
	 * 
	 * PagingAndSortingRepository
	 * CrudRepository 子接口，添加通用分页查询，排序查询功能
	 * findAll(Pageable pageable)	可进行分页排序查询
	 * Pageable 接口封装分页信息，
	 * PageRequest为Pageable实现，可封装分页，排序信息
	 * findAll(Sort sort)	进行排序查询
	 * Sort 类封装排序信息
	 * 
	 * JpaRepository
	 * PagingAndSortingRepository子接口，专门用于使用JPA操作关系型数据库
	 * 接口中将查询方法结果转换为List
	 * 
	 * Spring Data JPA 实现类
	 * SimpleJpaRepository
	 * 
	 * Spring Data JPA配置
	 * 在配置类上
	 * @EnableJpaRepositories开启Spring Data JPA，
	 * basePackageClasses 元素指定 Repository所在基础包，
	 * entityManagerFactoryRef 元素指明引用实体管理工厂bean id
	 * transactionManagerRef 元素指定事务管理器bean id
	 * @EnableTransactionManagement 开启事务
	 * 在配置类中，配置数据源，jpa厂商适配器，实体管理工厂，jpa事务管理器
	 * 
	 * 声明Repository接口
	 * 一般声明Repository接口会选择一个接口继承，
	 * 若仅想使用CrudRepository接口中的部分方法，可以继承Repository接口，在接口中拷贝需要的方法
	 * @NoRepositoryBean 标识的Repository接口将不会创建代理实现
	 * 
	 * Repository方法对null的处理
	 * @NonNullApi
	 * 使用在包上，用于约束类中方法参数及返回值不能为null
	 * @NonNull
	 * 使用于方法及方法参数上，用于约束方法参数及返回值不能为null
	 * @Nullable
	 * 使用于方法及方法参数上，用于指明方法参数及返回值可以为null
	 * 
	 * 自定义查询方法
	 * Spring Data 提供三种查询策略解析自定义查询方法，通过@EnableJpaRepositories queryLookupStrategy元素指定
	 * CREATE 策略
	 * 解析方法名构建查询语句
	 * USE_DECLARED_QUERY
	 * 寻找声明语句执行查询
	 * CREATE_IF_NOT_FOUND
	 * 优先使用声明语句，若语句不存在，解析方法名构建查询语句；CREATE_IF_NOT_FOUND为默认策略
	 * 
	 * 解析方法名构建查询语句
	 * 使用CREATE 策略解析方法名，方法名必须遵循规范，按照 动词-主题-断言 的模式定义，
	 * 动词 指定不同查询动作，
	 * 主题 可选，一般省略
	 * 断言 指定过滤条件，包括属性名及操作符
	 * 			省略操作符默认使用相等操作符
	 * 			多个过滤条件使用And和Or连接
	 * 			IgnoreCase用于忽略大小写进行比较，用于属性后
	 * 			断言结尾可以使用OrderBy指定排序字段及方式
	 * 主题与断言之间使用By分割
	 * 构建器会剔除find…By, read…By, query…By,get…By,count…By,delete…By,remove…By等方法前缀
	 * 当属性中嵌套属性，使用 _ 连接
	 * 语句中实际参数通过参数列表传入，参数列表中可传入Pageable，Sort实现分页查询，排序查询
	 * 
	 * 使用声明语句查询
	 * 在接口方法上使用@Query注解 定义查询语句
	 * 语句中使用？作为占位符，占位符后指定参数索引，运行时会使用实际参数替换占位符
	 * nativeQuery 元素设置为true时，执行sql查询
	 * 在执行update，delete查询时需使用@Modifying修饰
	 * clearAutomatically 元素指定修改后是否自动刷新缓存中实体
	 * 
	 * Spring Data JPA 注解
	 * @Entity	标识实体类，实体类与数据库表对应
	 * @Table	指定数据库表名
	 * @Id		标识数据库主键
	 * @GeneratedValue	指定主键生成策略
	 * @Basic	表示属性对应数据库中字段
	 * @Transient	表示属性不对应数据库字段
	 * @Column	指定属性对应数据库字段名
	 * @Temporal	指定Date类型属性对应数据库字段类型
	 * @Enumerated	？？？？？
	 * @Lob		将属性映射为blob，clob类型
	 */
}
