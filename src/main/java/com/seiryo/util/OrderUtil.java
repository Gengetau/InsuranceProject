package com.seiryo.util;

import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderUtil
 * @Description 订单业务层工具
 * @dateTime 14/10/2025 下午5:51
 */
public class OrderUtil {
	// 生成订单id
	public static String generateOrderId() {
		Random random = new Random();
		// 定义格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		// 获取当前时间
		LocalDateTime now = LocalDateTime.now();
		StringBuilder rand = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int row = random.nextInt(9);
			rand.append(row);
		}
		// 格式化输出！
		return now.format(formatter) + rand;
	}
	
	// 获取结束时间
	public static String getEndTime(String startTime, String length) {
		LocalDate start = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate endTime = start.plusYears(Integer.parseInt(length));
		return endTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
	
	// dto对象转化pojo对象
	public static <T> T convertToPojo(Object source, Class<T> clazz) {
		if (source == null) {
			return null;
		}
		T targetInstance;
		try {
			// 创建目标Pojo的实例
			targetInstance = clazz.newInstance();
			// 使用Spring的工具类来复制属性
			BeanUtils.copyProperties(source, targetInstance);
		} catch (InstantiationException | IllegalAccessException e) {
			// 如果创建实例失败，就抛出一个运行时异常
			throw new RuntimeException("创建POJO实例失败！", e);
		}
		return targetInstance;
	}
}
