package com.seiryo.dao;

import com.seiryo.pojo.CommodityLiabilityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityLiabilityInfoMapper
 * @Description 商品详情表持久层接口
 * @dateTime 14/10/2025 下午4:43
 */
@Mapper
public interface CommodityLiabilityInfoMapper {
	
	/**
	 * @param commodityId 商品id
	 * @return CommodityLiabilityInfo
	 * @MethodName: getCommodityLiabilityInfo
	 * @Description: 根据商品id查询商品详情
	 */
	@Select("SELECT * FROM Commodity_Liability_Info WHERE Commodity_Id = #{commodityId}")
	CommodityLiabilityInfo getCommodityLiabilityInfo(Integer commodityId);
}
