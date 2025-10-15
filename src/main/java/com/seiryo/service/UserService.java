package com.seiryo.service;

import com.seiryo.dto.*;
import com.seiryo.enums.ResponseCode;
import com.seiryo.vo.OrderVO;
import com.seiryo.vo.PageBean;

import java.util.Map;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserService
 * @Description 用户业务层接口
 * @dateTime 14/10/2025 下午12:07
 */
public interface UserService {
	/**
	 * @param loginDTO 登录表单
	 * @return Map<String,Object> 用户信息和响应码
	 * @MethodName: login
	 * @Description: 登录方法
	 */
	Map<String, Object> login(LoginDTO loginDTO);
	
	/**
	 * @param registerDTO 注册表单
	 * @return 信息
	 * @MethodName: register
	 * @Description: 注册方法
	 */
	ResponseCode register(RegisterDTO registerDTO);
	
	/**
	 * @param chargeMoneyDTO 充值表单
	 * @return ResponseCode
	 * @MethodName: chargeMoney
	 * @Description: 余额充值
	 */
	ResponseCode chargeMoney(ChargeMoneyDTO chargeMoneyDTO);
	
	/**
	 * @param passwordDTO 密码表单
	 * @return ResponseCode
	 * @MethodName: passwordCheck
	 * @Description: 密码验证（修改用）
	 */
	ResponseCode passwordCheck(PasswordDTO passwordDTO);
	
	/**
	 * @param passwordDTO 密码表单
	 * @return ResponseCode
	 * @MethodName: changePassword
	 * @Description: 密码修改
	 */
	ResponseCode changePassword(PasswordDTO passwordDTO);
	
	/**
	 * @param changeInfoDTO 用户信息修改表单
	 * @return ResponseCode
	 * @MethodName: updateUserPhone
	 * @Description: 修改手机号
	 */
	ResponseCode updateUserPhone(ChangeInfoDTO changeInfoDTO);
	
	/**
	 * @param pageDTO 分页查询表单
	 * @return PageBean<OrderVO>
	 * @MethodName: findMyOrders
	 * @Description: 查询我的订单记录
	 */
	PageBean<OrderVO> findMyOrders(PageDTO pageDTO);
	
	/**
	 * @param email 输入的邮箱
	 * @return ResponseCode
	 * @MethodName: emailCheck
	 * @Description: 注册邮箱验证
	 */
	ResponseCode emailCheck(String email);
	
	/**
	 * @param userid 用户id
	 * @return 返回余额
	 * @MethodName: getUserMoney
	 * @Description: 获取用户余额
	 */
	String getUserMoney(Integer userid);
}
