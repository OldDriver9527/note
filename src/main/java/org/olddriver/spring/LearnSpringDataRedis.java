package org.olddriver.spring;
/**
 * 
 * Spring Data Redis 笔记
 *
 */
public class LearnSpringDataRedis {
	/*
	 * redis 
	 * 非关系型数据库，用于存储键值对，
	 * redis支持五种类型的value值，包括字符串，散列，集合，有序集合，列表
	 * 可以将redis数据库类比为HashMap
	 * 
	 * Spring Data Redis
	 * spring提供操作redis持久层框架，通过模板减少样板式代码，简化redis开发
	 * Spring Data Redis要求redis版本高于2.6，
	 * Spring Data Redis中可以集成jedis，Lettuce驱动
	 * 
	 * 连接redis
	 * Spring Data Redis 使用 RedisConnectionFactory 创建 RedisConnection，
	 * Spring Data Redis 提供多种RedisConnectionFactory 实现，如JedisConnectionFactory
	 * 通过配置redis连接工厂，可以设置redis服务器 主机，端口，密码
	 * 高版本JedisConnectionFactory建议使用RedisStandaloneConfiguration配置redis服务主机，端口，密码，
	 * 使用JedisClientConfiguration配置连接池参数
	 * 
	 * redis模板类 RedisTemplate，StringRedisTemplate
	 * RedisTemplate支持五种类型value
	 * StringRedisTemplate支持string类型value
	 * 
	 * 序列化器 Serializer
	 * RedisTemplate 保存key，value时会对键值进行序列化，
	 * RedisTemplate 默认使用JdkSerializationRedisSerializer进行java序列化，会在key，value前添加字符，
	 * StringRedisTemplate 默认使用StringRedisSerializer进行序列化
	 * 
	 * RedisTemplate操作
	 * 1.ValueOperations 对string类型value进行操作
	 * 	  BoundValueOperations 对指定key的string进行操作
	 * 2.ListOperations 对列表类型value进行操作
	 *    BoundListOperations 对指定key的列表进行操作
	 * 3.SetOperations 对集合类型value进行操作
	 *    BoundSetOperations 对指定key的集合进行操作
	 * 4.ZSetOperations 对有序集合类型value进行操作
	 *    BoundZSetOperations 对指定key的有序集合进行操作
	 * 5.HashOperations 对散列类型value进行操作
	 *    BoundHashOperations 对指定key的散列进行操作
	 */
}
