package com.seiryo.util;

import com.seiryo.pojo.Commodity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityUtil
 * @Description 商品业务层工具
 * @dateTime 14/10/2025 下午3:03
 */
public class CommodityUtil {
	/**
	 * 计算年龄的工具
	 *
	 * @param birthday 生日字符串，格式是 "yyyyMMdd"
	 * @return 年龄
	 */
	public static Integer calculateAge(String birthday) {
		if (birthday == null || birthday.length() != 8) {
			return null;
		}
		try {
			LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
			LocalDate currentDate = LocalDate.now();
			return Period.between(birthDate, currentDate).getYears();
		} catch (Exception e) {
			// 如果日期格式不对，就打印一个日志，然后返回null
			System.err.println("生日格式解析错误: " + birthday);
			return null;
		}
	}
	
	/**
	 * 计算“年龄贴合度”分数的工具
	 *
	 * @param commodity 商品
	 * @param userAge   用户年龄
	 * @return 推荐分数 (0-1之间，越高越好)
	 */
	public static double calculateScore(Commodity commodity, Integer userAge) {
		if (userAge == null) {
			return 0;
		}
		Integer startAge = commodity.getCommodityAgeStart();
		Integer endAge = commodity.getCommodityAgeEnd();
		if (startAge == null || endAge == null || startAge > endAge) {
			return 0;
		}
		
		// 找到年龄区间的中心点
		double midPoint = startAge + (endAge - startAge) / 2.0;
		// 计算用户年龄与中心点的距离
		double distance = Math.abs(userAge - midPoint);
		// 年龄范围的一半
		double halfRange = (endAge - startAge) / 2.0;
		
		// 如果范围是0，说明是特定年龄，只要匹配上就给满分
		if (halfRange == 0) {
			return distance == 0 ? 1.0 : 0;
		}
		
		// 距离越小，分数越高
		return 1.0 - (distance / halfRange);
	}
}
