package com.seiryo.dao;

import com.seiryo.pojo.MyOrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderInfoMapper
 * @Description 订单详情表持久层接口
 * @dateTime 14/10/2025 下午5:25
 */
@Mapper
public interface OrderInfoMapper {
	/**
	 * @param orderInfo pojo
	 * @return 受影响的行数
	 * @MethodName: addNewOrderInfo
	 * @Description: 插入新的订单详情表数据
	 */
	int addNewOrderInfo(MyOrderInfo orderInfo);
}
