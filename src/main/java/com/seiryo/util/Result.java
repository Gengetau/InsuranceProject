package com.seiryo.util;

import com.seiryo.enums.ResponseCode;
import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName Result
 * @Description 后端统一返回结果封装
 * @dateTime 14/10/2025 下午12:09
 */
@Data
public class Result {
	private Integer code; // 响应码, 200 代表成功; 401 代表失败
	private String message; // 响应消息
	private Object data;    // 返回的数据
	
	public static Result success(Object data) {
		Result result = new Result();
		result.setCode(ResponseCode.SUCCESS.getCode());
		result.setMessage(ResponseCode.SUCCESS.getMessage());
		result.setData(data);
		return result;
	}
	
	public static Result error() {
		Result result = new Result();
		result.setCode(ResponseCode.ERROR.getCode());
		result.setMessage(ResponseCode.ERROR.getMessage());
		return result;
	}
	
	/**
	 * 成功响应（不带数据）
	 *
	 * @return Result
	 */
	public static Result success() {
		return success(null);
	}
	
	/**
	 * 失败响应（使用枚举）
	 *
	 * @param responseCode 响应码枚举
	 * @return Result
	 */
	public static Result error(ResponseCode responseCode) {
		Result result = new Result();
		result.setCode(responseCode.getCode());
		result.setMessage(responseCode.getMessage());
		return result;
	}
	
	/**
	 * 失败响应（自定义消息）
	 *
	 * @param code    状态码
	 * @param message 消息
	 * @return Result
	 */
	public static Result error(Integer code, String message) {
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
	
	/**
	 * 自定义响应
	 *
	 * @param code    状态码
	 * @param message 消息
	 * @return Result
	 */
	public static Result info(Integer code, String message) {
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
}
