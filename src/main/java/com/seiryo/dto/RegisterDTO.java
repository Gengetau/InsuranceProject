package com.seiryo.dto;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName RegisterDTO
 * @Description 注册表单
 * @dateTime 14/10/2025 下午12:43
 */
@Data
public class RegisterDTO {
	private String username;
	private String birthday;
	private String gender;
	private String phone;
	private String email;
	private String password;
}
