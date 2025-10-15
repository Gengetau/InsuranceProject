package com.seiryo.service.impl;

import com.seiryo.dao.OrderInfoMapper;
import com.seiryo.dao.OrderMapper;
import com.seiryo.dao.UserInfoMapper;
import com.seiryo.dto.OrderDTO;
import com.seiryo.enums.ResponseCode;
import com.seiryo.pojo.MyOrder;
import com.seiryo.pojo.MyOrderInfo;
import com.seiryo.service.OrderService;
import com.seiryo.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderServiceImpl
 * @Description 订单业务层接口实现类
 * @dateTime 14/10/2025 下午5:34
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseCode addNewOrder(OrderDTO orderDTO) {
		// 1.获取总价，userid,commodityId
		Integer userId = orderDTO.getUserid();
		String sumPrice = orderDTO.getOrderSumPrice();
		
		// 2.获取余额
		String userMoney = userInfoMapper.getUserMoneyByUserid(userId);
		
		if (userMoney == null) {
			return ResponseCode.BALANCE_NOT_ENOUGH;
		}
		
		// 3.转化
		BigDecimal totalPrice = new BigDecimal(sumPrice);
		BigDecimal balance = new BigDecimal(userMoney);
		
		// 4.比较
		BigDecimal finalMoney = balance.subtract(totalPrice);
		if (finalMoney.compareTo(BigDecimal.ZERO) < 0) {
			// 余额不足，返回
			return ResponseCode.BALANCE_NOT_ENOUGH;
		}
		
		// 5.更改余额
		userMoney = finalMoney.toString();
		int cow1 = userInfoMapper.updateUserMoneyByUserid(userId, userMoney);
		
		// 6.生成订单id
		String orderId = OrderUtil.generateOrderId();
		
		// 7.创建订单
		MyOrder myOrder = OrderUtil.convertToPojo(orderDTO, MyOrder.class);
		myOrder.setOrderId(orderId);
		
		// 8.插入订单主表
		int cow2 = orderMapper.addNewOrder(myOrder);
		
		// 9.创建订单详情表
		MyOrderInfo myOrderInfo = OrderUtil.convertToPojo(orderDTO, MyOrderInfo.class);
		myOrderInfo.setOrderId(orderId);
		String timeEnd = OrderUtil.getEndTime(myOrderInfo.getOrderCommodityTimeStart(), myOrderInfo.getOrderCommodityTimeLength());
		myOrderInfo.setOrderCommodityTimeEnd(timeEnd);
		
		// 10.插入订单详情表
		int cow3 = orderInfoMapper.addNewOrderInfo(myOrderInfo);
		
		// 11.判断
		if (cow1 > 0 && cow2 > 0 && cow3 > 0) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.ERROR;
	}
}
