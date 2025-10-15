package com.seiryo.controller;

import com.seiryo.dto.OrderDTO;
import com.seiryo.enums.ResponseCode;
import com.seiryo.service.OrderService;
import com.seiryo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderController
 * @Description 订单视图层控制器
 * @dateTime 14/10/2025 下午6:28
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	// 购买保险接口
	@PostMapping("/insert")
	public Result addNewOrder(@RequestBody OrderDTO orderDTO) {
		ResponseCode responseCode = orderService.addNewOrder(orderDTO);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
}
