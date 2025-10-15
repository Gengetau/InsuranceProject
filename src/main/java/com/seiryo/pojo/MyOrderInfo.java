package com.seiryo.pojo;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName MyOrderInfo
 * @Description 订单详情表pojo
 * @dateTime 14/10/2025 下午5:10
 */
@Data
public class MyOrderInfo {
	private Integer orderInfoId;
	private String orderId;
	private String orderCommodityLiability1;//'客制化责任1金额',
	private String orderCommodityLiability2;//'客制化责任2金额',
	private String orderCommodityLiability3;//'客制化责任3金额',
	private String orderCommodityLiability4;//'客制化责任4金额',
	private String orderCommodityLiability5;//'客制化责任5金额',
	private String orderCommodityLiability6;//'客制化责任6金额',
	private String orderCommodityLiability7;//'客制化责任7金额',
	private String orderBeneficiaryName;// '受益人姓名',
	private String orderBeneficiaryCity;// '受益人城市',
	private String orderBeneficiaryPhone;// '受益人电话',
	private String orderCommodityTimeStart;// 开始日期
	private String orderCommodityTimeEnd;// 结束日期
	private String orderCommodityTimeLength;// 持续时间
	private String orderSumPrice;// 总价
	private String o1;
	private String o2;
	private String o3;
}
