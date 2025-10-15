package com.seiryo.service;

import com.seiryo.dto.UserInfoDTO;
import com.seiryo.vo.CommodityDetailVO;
import com.seiryo.vo.CommodityIndexVO;
import com.seiryo.vo.CommodityLiabilityInfoVO;

import java.util.List;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityService
 * @Description 商品业务层接口
 * @dateTime 14/10/2025 下午2:54
 */
public interface CommodityService {
	/**
	 * @param userInfo 用户信息表单
	 * @return CommodityIndexVO 集合
	 * @MethodName: findCommodityIndex
	 * @Description: 首页展示保险查询
	 */
	List<CommodityIndexVO> findCommodityIndex(UserInfoDTO userInfo);
	
	/**
	 * @param commodityId 商品id
	 * @return CommodityDetailVO 商品详情页视图对象
	 * @MethodName: findCommodityDetailById
	 * @Description: 根据id查询商品详情
	 */
	CommodityDetailVO findCommodityDetailById(Integer commodityId);
	
	/**
	 * @param commodityId 商品id
	 * @return CommodityLiabilityInfoVO
	 * @MethodName: findCommodityLiabilityById
	 * @Description: 根据id查询商品详情
	 */
	CommodityLiabilityInfoVO findCommodityLiabilityById(Integer commodityId);
}
