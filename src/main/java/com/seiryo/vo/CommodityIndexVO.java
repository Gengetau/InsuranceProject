package com.seiryo.vo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityVO
 * @Description 前端首页展示保险数据
 * @dateTime 14/10/2025 下午2:20
 */
@Data
public class CommodityIndexVO {
	private Integer commodityId;
	private String commodityName;
	private String commodityPrice;
	private String commodityIntroduce;
	private String commodityImg;
}
