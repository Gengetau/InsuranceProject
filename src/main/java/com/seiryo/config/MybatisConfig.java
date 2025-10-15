package com.seiryo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName MybatisConfig
 * @Description mybatis配置类
 * @dateTime 14/10/2025 上午11:39
 */
public class MybatisConfig {
	@Bean
	public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setTypeAliasesPackage("com.seiryo.pojo");
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		// 1. 创建一个 MyBatis 的配置对象
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// 2. 开启下划线到驼峰的自动映射
		configuration.setMapUnderscoreToCamelCase(true);
		// 3. 把这个配置好的对象设置给 SqlSessionFactoryBean
		sqlSessionFactoryBean.setConfiguration(configuration);
		return sqlSessionFactoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.seiryo.dao");
		return mapperScannerConfigurer;
	}
}
