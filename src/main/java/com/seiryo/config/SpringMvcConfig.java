package com.seiryo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName SpringMvcConfig
 * @Description springmvc配置类
 * @dateTime 14/10/2025 上午11:41
 */
@Configuration
@ComponentScan("com.seiryo.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
	/**
	 * @param registry CORS配置注册器
	 * @MethodName: addCorsMappings
	 * @Description: 在这里配置全局的跨域访问规则！
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // 对我们所有的 /api/ 路径下的接口生效
				.allowedOrigins("http://localhost:5173") // 允许来自前端应用的这个地址的请求
				.allowedMethods("GET", "POST", "PUT", "DELETE") // 允许这些HTTP方法
				.allowedHeaders("Authorization", "Content-Type") // 允许这些请求头
				.allowCredentials(true) // 允许携带凭证（比如Cookie）
				.maxAge(3600); // 预检请求的有效期，单位是秒喵
	}
}
