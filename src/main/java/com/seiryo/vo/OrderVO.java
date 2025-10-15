package com.seiryo.vo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderVO
 * @Description 订单展示视图对象
 * @dateTime 14/10/2025 下午10:07
 */
@Data
public class OrderVO {
	private String orderId;// 订单号
	private String commodityName;// 保险名
	private String orderSumPrice;// 投保价格
	private String userName;// 投保人
	private String orderBeneficiaryName;// '受益人姓名',
	private String orderCommodityTimeStart;// 开始日期
	private String orderCommodityTimeEnd;// 结束日期
	private String orderCommodityTimeLength;// 持续时间
}
