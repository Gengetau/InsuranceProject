package com.seiryo.service;

import com.seiryo.dto.OrderDTO;
import com.seiryo.enums.ResponseCode;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderService
 * @Description 订单业务层接口
 * @dateTime 14/10/2025 下午5:33
 */
public interface OrderService {
	/**
	 * @param orderDTO 订单表单
	 * @return ResponseCode
	 * @MethodName: addNewOrder
	 * @Description: 购买保险业务
	 */
	ResponseCode addNewOrder(OrderDTO orderDTO);
}
