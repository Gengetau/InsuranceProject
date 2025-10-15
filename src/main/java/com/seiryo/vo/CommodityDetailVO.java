package com.seiryo.vo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityDetailVO
 * @Description 商品详情页视图对象
 * @dateTime 14/10/2025 下午3:45
 */
@Data
public class CommodityDetailVO {
	private Integer commodityId;                      // '商品ID (主键)'
	private String commodityPrice;                    // '商品价格',
	private Integer commodityAgeStart;                // '适用起始年龄',
	private Integer commodityAgeEnd;                  // '适用结束年龄',
	private String commodityTimeLength;               // '保险时长',
	private String commodityApplicableGender;         // '适用性别 (例如: "0"女, "1"男, "2"通用)',
	private String commodityApplicableLocation;       // '适用地区',
	private String commoditySigningForm;              // '签署形式 (例如: 电子保单)',
	private String commodityLiabilityZjs;             // '主要保险责任简介',
	private String commodityDetailedInformation1;     // '详情页图片1路径',
}
