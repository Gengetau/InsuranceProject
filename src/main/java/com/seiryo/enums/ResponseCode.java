package com.seiryo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName Enum
 * @Description 统一响应枚举类
 * @dateTime 14/10/2025 下午1:06
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
	// ------------------- 通用成功 -------------------
	SUCCESS(200, "操作成功！"),
	
	// ------------------- 通用失败 -------------------
	ERROR(401, "操作失败！"),
	
	// ------------------- 客户端错误 (4xx) -------------------
	
	// ------------------- 服务端错误 (5xx) -------------------
	
	
	// ------------------- 自定义业务逻辑错误 (1000+) -------------------
	// 用户相关
	USER_NOT_FOUND(1001, "用户不存在"),
	USER_PASSWORD_ERROR(1002, "密码错误"),
	CHARGE_ERROR(1003, "充值失败"),
	USERNAME_ALREADY_EXISTS(1004, "这个邮箱已经被注册了"),
	
	// 商品相关
	COMMODITY_NOT_FOUND(5001, "商品查询失败，请重试!"),
	INFO_NOT_FOUND(5002, "商品信息获取失败，请重试！"),
	
	// 参数校验相关
	
	
	// 订单相关
	BALANCE_NOT_ENOUGH(3001, "余额不足，请充值！");
	
	
	// JWT Token 相关
	
	
	/**
	 * 响应状态码
	 */
	private final int code;
	
	/**
	 * 响应提示信息
	 */
	private final String message;
}
