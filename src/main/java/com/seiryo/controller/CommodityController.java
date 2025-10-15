package com.seiryo.controller;

import com.seiryo.dto.UserInfoDTO;
import com.seiryo.enums.ResponseCode;
import com.seiryo.service.CommodityService;
import com.seiryo.util.Result;
import com.seiryo.vo.CommodityDetailVO;
import com.seiryo.vo.CommodityIndexVO;
import com.seiryo.vo.CommodityLiabilityInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName CommodityController
 * @Description 商品视图层控制器
 * @dateTime 14/10/2025 下午3:22
 */
@RestController
@RequestMapping("/api/commodity")
public class CommodityController {
	@Autowired
	private CommodityService commodityService;
	
	// 首页保险展示
	@PostMapping("/selectIndex")
	public Result findCommodityIndex(@RequestBody UserInfoDTO userInfo) {
		List<CommodityIndexVO> commodityIndex = commodityService.findCommodityIndex(userInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("commodity", commodityIndex);
		if (commodityIndex != null) {
			return Result.success(map);
		}
		return Result.error(ResponseCode.COMMODITY_NOT_FOUND);
	}
	
	// 保险详情页展示
	@GetMapping("/selectDetail")
	public Result findCommodityByCommodityId(@RequestParam("commodityId") Integer commodityId) {
		CommodityDetailVO detailVO = commodityService.findCommodityDetailById(commodityId);
		Map<String, Object> map = new HashMap<>();
		map.put("commodity", detailVO);
		if (detailVO != null) {
			return Result.success(map);
		}
		return Result.error(ResponseCode.COMMODITY_NOT_FOUND);
	}
	
	// 保险责任展示
	@GetMapping("/selectInfo")
	public Result findCommodityInfoById(@RequestParam("commodityId") Integer commodityId) {
		CommodityLiabilityInfoVO infoVO = commodityService.findCommodityLiabilityById(commodityId);
		Map<String, Object> map = new HashMap<>();
		map.put("info", infoVO);
		if (infoVO != null) {
			return Result.success(map);
		}
		return Result.error(ResponseCode.INFO_NOT_FOUND);
	}
}
