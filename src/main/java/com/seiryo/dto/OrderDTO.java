package com.seiryo.dto;

import lombok.Data;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityDTO
 * @Description 保险购入表单
 * @dateTime 14/10/2025 下午4:57
 */
@Data
public class OrderDTO {
	private Integer userid;
	private Integer commodityId;
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
	private String orderCommodityTimeLength;// 持续时间
	private String orderSumPrice;// 总价
}
