package com.seiryo.pojo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName MyOrder
 * @Description 订单主表pojo
 * @dateTime 14/10/2025 下午5:05
 */
@Data
public class MyOrder {
	private String orderId;           //'订单ID (主键)'
	private Integer userid;           //'用户ID (关联my_user.user_id)',
	private Integer commodityId;      //'商品ID (关联commodity.commodity_id)'
	private String o1;                //'预留字段1',
	private String o2;                //'预留字段2',
	private String o3;                //'预留字段3'
}
