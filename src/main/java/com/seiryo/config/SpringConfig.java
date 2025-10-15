package com.seiryo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName SpringConfig
 * @Description spring核心配置
 * @dateTime 14/10/2025 上午11:34
 */
@Configuration
@ComponentScan(value = "com.seiryo",
		excludeFilters = @ComponentScan.Filter(
				type = FilterType.ANNOTATION,
				classes = Controller.class
		))
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
	/**
	 * @return BCryptPasswordEncoder
	 * @MethodName: passwordEncoder
	 * @Description: 将 BCryptPasswordEncoder 注入到 Spring 容器中，作为 Bean 进行管理！
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
