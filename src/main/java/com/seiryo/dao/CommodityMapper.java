package com.seiryo.dao;

import com.seiryo.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityMapper
 * @Description 保险商品持久层接口
 * @dateTime 14/10/2025 下午2:40
 */
@Mapper
public interface CommodityMapper {
	/**
	 * @param userAge    用户年龄
	 * @param userGender 用户性别
	 * @return 保险集合
	 * @MethodName: findRecommendedCommodities
	 * @Description: 根据用户年龄和性别筛选推荐的保险商品
	 */
	List<Commodity> findRecommendedCommodities(@Param("userAge") Integer userAge, @Param("userGender") String userGender);
	
	/**
	 * @param commodityId 商品id
	 * @return Commodity
	 * @MethodName: findCommodityById
	 * @Description: 根据id查询商品信息
	 */
	@Select("SELECT * FROM Commodity WHERE Commodity_Id = #{commodityId}")
	Commodity findCommodityById(@Param("commodityId") Integer commodityId);
}
