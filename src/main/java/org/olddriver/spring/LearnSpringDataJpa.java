package org.olddriver.spring;
/**
 * 
 * spring data jpa 笔记
 * 中文文档仓库	ityouknow/spring-data-jpa-reference-documentation
 *
 */
public class LearnSpringDataJpa {
	/*
	 * Spring Data JPA 是spring 在持久层的应用
	 * Spring Data JPA 通过 hibernate jpa 实现
	 * 
	 * Spring Data JPA 核心接口
	 * Repository接口
	 * Repository 是 spring data jpa 中顶层接口，以操作实体类，实体类主键类型为泛型参数
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
	 * CrudRepository 接口子接口，添加通用分页查询，排序查询功能
	 * 
	 */
}
