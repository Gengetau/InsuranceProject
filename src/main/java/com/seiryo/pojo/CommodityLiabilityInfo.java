package com.seiryo.pojo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityLiabilityInfo
 * @Description 商品责任详情表pojo
 * @dateTime 14/10/2025 下午4:41
 */
@Data
public class CommodityLiabilityInfo {
	private Integer commodityLiabilityInfoId;        // '责任信息ID (主键)'
	private Integer commodityId;                     // '关联的商品ID',
	private String commodityLiabilityInfo1;          // '责任描述1',
	private String commodityLiabilityInfo2;          // '责任描述2',
	private String commodityLiabilityInfo3;          // '责任描述3',
	private String commodityLiabilityInfo4;          // '责任描述4',
	private String commodityLiabilityInfo5;          // '责任描述5',
	private String commodityLiabilityInfo6;          // '责任描述6',
	private String commodityLiabilityInfo7;          // '责任描述7',
	private String c1;                               // '预留字段1',
	private String c2;                               // '预留字段2',
	private String c3;                               // '预留字段3'
}
