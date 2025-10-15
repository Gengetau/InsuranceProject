package com.seiryo.dto;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName LoginDTO
 * @Description 登录表单信息
 * @dateTime 14/10/2025 上午11:53
 */
@Data
public class LoginDTO {
	private String email;
	private String password;
}
