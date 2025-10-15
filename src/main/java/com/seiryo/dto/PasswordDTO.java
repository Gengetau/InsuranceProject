package com.seiryo.dto;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName ChangePassDTO
 * @Description 密码修改表单
 * @dateTime 14/10/2025 下午9:45
 */
@Data
public class PasswordDTO {
	private Integer userid;
	private String password;
}
