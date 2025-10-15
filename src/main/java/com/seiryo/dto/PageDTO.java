package com.seiryo.dto;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName PageDTO
 * @Description 分页查询表单
 * @dateTime 14/10/2025 下午10:22
 */
@Data
public class PageDTO {
	private int currentPage;
	private int pageSize;
	private Integer userid;
}
