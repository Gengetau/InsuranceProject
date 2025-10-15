package com.seiryo.pojo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName Commodity
 * @Description 商品表实体类
 * @dateTime 14/10/2025 下午2:41
 */
@Data
public class Commodity {
	private Integer commodityId;                     //  '商品ID (主键)'
	private String commodityName;                    // '商品名称',
	private String commodityPrice;                   // '商品价格',
	private String commodityIntroduce;               // '商品简介',
	private String commodityImg;                     // '商品列表图片路径',
	private Integer commodityAgeStart;               // '适用起始年龄',
	private Integer commodityAgeEnd;                 // '适用结束年龄',
	private String commodityTimeLength;              // '保险时长',
	private String commodityApplicableGender;        // '适用性别 (例如: "0"女, "1"男, "2"通用)',
	private String commodityApplicableLocation;      // '适用地区',
	private String commoditySigningForm;             // '签署形式 (例如: 电子保单)',
	private String commodityLiabilityZjs;            // '主要保险责任简介',
	private String commodityDetailedInformation1;    // '详情页图片1路径',
	private String commodityDetailedInformation2;    // '详情页图片2路径',
	private String commodityDetailedInformation3;    // '详情页图片3路径',
	private String commodityType;                    // '商品类型',
	private String c1;                               // '预留字段1',
	private String c2;                               // '预留字段2',
	private String c3;                               // '预留字段3'
}
