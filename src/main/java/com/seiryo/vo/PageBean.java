package com.seiryo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName PageBean
 * @Description 分页查询结果返回
 * @dateTime 14/10/2025 下午10:23
 */
@Data
public class PageBean<T> {
	private List<T> list;
	private int total;
}
