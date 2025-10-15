package com.seiryo.vo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserVO
 * @Description 用户视图展示对象
 * @dateTime 14/10/2025 下午4:17
 */
@Data
public class UserVO {
	private Integer userid;
	private String userEmail;
	private String userPhone;
	private String userMoney;
	private String userName;
	private String userBirthday;
	private String userSex;
}
