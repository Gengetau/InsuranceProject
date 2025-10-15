package com.seiryo.dao;

import com.seiryo.pojo.MyOrder;
import com.seiryo.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName OrderMapper
 * @Description 订单主表持久层接口
 * @dateTime 14/10/2025 下午5:19
 */
@Mapper
public interface OrderMapper {
	/**
	 * @param order pojo对象
	 * @return 受影响的行数
	 * @MethodName: addNewOrder
	 * @Description: 插入订单主表
	 */
	int addNewOrder(MyOrder order);
	
	/**
	 * @param userid   用户id
	 * @param begin    索引
	 * @param pageSize 每页显示条数
	 * @return OrderVO集合
	 * @MethodName: findMyOrder
	 * @Description: 分页查询我的投保记录
	 */
	List<OrderVO> findMyOrder(@Param("userid") Integer userid, @Param("begin") int begin, @Param("pageSize") int pageSize);
	
	/**
	 * @param userid 用户id
	 * @return 投保记录总数
	 * @MethodName: countMyOrder
	 * @Description: 计算投保记录数量
	 */
	int countMyOrder(@Param("userid") Integer userid);
}
