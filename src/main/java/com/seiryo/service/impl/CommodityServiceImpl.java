package com.seiryo.service.impl;

import com.seiryo.dao.CommodityLiabilityInfoMapper;
import com.seiryo.dao.CommodityMapper;
import com.seiryo.dto.UserInfoDTO;
import com.seiryo.pojo.Commodity;
import com.seiryo.pojo.CommodityLiabilityInfo;
import com.seiryo.service.CommodityService;
import com.seiryo.util.CommodityUtil;
import com.seiryo.vo.CommodityDetailVO;
import com.seiryo.vo.CommodityIndexVO;
import com.seiryo.vo.CommodityLiabilityInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityServiceImpl
 * @Description 商品业务层接口实现类
 * @dateTime 14/10/2025 下午2:56
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private CommodityLiabilityInfoMapper commodityLiabilityInfoMapper;
	
	@Override
	public List<CommodityIndexVO> findCommodityIndex(UserInfoDTO userInfo) {
		Integer userAge = null;
		String userGender = null;
		
		if (userInfo != null && userInfo.getBirthday() != null) {
			// 调用工具方法获取年龄
			userAge = CommodityUtil.calculateAge(userInfo.getBirthday());
			userGender = userInfo.getGender();
		}
		
		// 获取数据
		List<Commodity> commodities = commodityMapper.findRecommendedCommodities(userAge, userGender);
		
		// 智能排序
		if (userAge != null) {
			final Integer finalUserAge = userAge;
			// 使用java Stream API进行排序
			commodities.sort(Comparator
					// 主要排序条件：按年龄贴合度分数降序排列
					.comparingDouble((Commodity c) -> CommodityUtil.calculateScore(c, finalUserAge)).reversed()
					// 次要条件：如果分数相同，按价格升序排列
					.thenComparing(c -> Double.parseDouble(c.getCommodityPrice()))
			);
		} else {
			// 没有用户信息，按价格升序排序
			commodities.sort(Comparator.comparing(c -> Double.parseDouble(c.getCommodityPrice())));
		}
		
		// 转化为vo视图对象列表返回
		return commodities.stream()
				.map(commodity -> convertToVO(commodity, CommodityIndexVO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public CommodityDetailVO findCommodityDetailById(Integer commodityId) {
		Commodity commodity = commodityMapper.findCommodityById(commodityId);
		return convertToVO(commodity, CommodityDetailVO.class);
	}
	
	@Override
	public CommodityLiabilityInfoVO findCommodityLiabilityById(Integer commodityId) {
		CommodityLiabilityInfo info = commodityLiabilityInfoMapper.getCommodityLiabilityInfo(commodityId);
		return convertToVO(info, CommodityLiabilityInfoVO.class);
	}
	
	/**
	 * 把任意源对象转换成目标VO对象的通用工具
	 *
	 * @param source 源数据对象
	 * @param clazz  目标VO的Class对象
	 * @param <T>    目标的类型
	 * @return 创建并复制好属性的目标VO对象
	 */
	private <T> T convertToVO(Object source, Class<T> clazz) {
		if (source == null) {
			return null;
		}
		T targetInstance;
		try {
			// 创建目标VO的实例
			targetInstance = clazz.newInstance();
			// 使用Spring的工具类来复制属性
			BeanUtils.copyProperties(source, targetInstance);
		} catch (InstantiationException | IllegalAccessException e) {
			// 如果创建实例失败，就抛出一个运行时异常
			throw new RuntimeException("创建VO实例失败！", e);
		}
		return targetInstance;
	}
}
