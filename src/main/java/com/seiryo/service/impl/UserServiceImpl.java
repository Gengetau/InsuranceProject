package com.seiryo.service.impl;

import com.seiryo.dao.OrderMapper;
import com.seiryo.dao.UserInfoMapper;
import com.seiryo.dao.UserMapper;
import com.seiryo.dto.*;
import com.seiryo.enums.ResponseCode;
import com.seiryo.pojo.MyUser;
import com.seiryo.pojo.MyUserInfo;
import com.seiryo.service.UserService;
import com.seiryo.vo.OrderVO;
import com.seiryo.vo.PageBean;
import com.seiryo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserServiceImpl
 * @Description 用户业务层接口实现类
 * @dateTime 14/10/2025 下午12:07
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Map<String, Object> login(LoginDTO loginDTO) {
		String email = loginDTO.getEmail();
		String password = loginDTO.getPassword();
		Map<String, Object> map = new HashMap<>();
		
		MyUser userByEmail = userMapper.getUserByEmail(email);
		map.put("user", null);
		map.put("status", ResponseCode.USER_NOT_FOUND);
		
		if (userByEmail != null) {
			// 哈希校验
			boolean matches = passwordEncoder.matches(password, userByEmail.getUserPassword());
			if (matches) {
				MyUserInfo userInfo = userInfoMapper.getUserInfoByUserid(userByEmail.getUserid());
				UserVO userVO = new UserVO();
				// 复制属性
				BeanUtils.copyProperties(userByEmail, userVO);
				BeanUtils.copyProperties(userInfo, userVO);
				map.put("user", userVO);
				map.put("status", ResponseCode.SUCCESS);
				return map;
			}
			map.put("status", ResponseCode.USER_PASSWORD_ERROR);
		}
		return map;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseCode register(RegisterDTO registerDTO) {
		String email = registerDTO.getEmail();
		String password = registerDTO.getPassword();
		MyUser userByEmail = userMapper.getUserByEmail(email);
		if (userByEmail != null) {
			return ResponseCode.USERNAME_ALREADY_EXISTS;
		}
		// 哈希加密
		String hashPassword = passwordEncoder.encode(password);
		MyUser user = new MyUser();
		user.setUserEmail(email);
		user.setUserPassword(hashPassword);
		
		userMapper.addNewUser(user);
		
		MyUserInfo userInfo = new MyUserInfo();
		userInfo.setUserid(user.getUserid());
		userInfo.setUserPhone(registerDTO.getPhone());
		userInfo.setUserName(registerDTO.getUsername());
		userInfo.setUserBirthday(registerDTO.getBirthday());
		userInfo.setUserSex(registerDTO.getGender());
		int cows = userInfoMapper.addNewUserInfo(userInfo);
		if (cows > 0) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.ERROR;
	}
	
	@Override
	public ResponseCode chargeMoney(ChargeMoneyDTO chargeMoneyDTO) {
		String money = chargeMoneyDTO.getMoney();
		Integer userid = chargeMoneyDTO.getUserid();
		
		// 查询当前余额
		String userMoney = userInfoMapper.getUserMoneyByUserid(userid);
		
		BigDecimal userMoneyBigDecimal = new BigDecimal(0);
		
		if (userMoney != null) {
			userMoneyBigDecimal = userMoneyBigDecimal.add(new BigDecimal(userMoney));
		}
		
		// 充值
		BigDecimal chargeMoneyBigDecimal = new BigDecimal(money);
		
		BigDecimal finalMoney = userMoneyBigDecimal.add(chargeMoneyBigDecimal);
		
		userMoney = finalMoney.toString();
		
		int cows = userInfoMapper.updateUserMoneyByUserid(userid, userMoney);
		if (cows > 0) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.CHARGE_ERROR;
	}
	
	@Override
	public ResponseCode passwordCheck(PasswordDTO passwordDTO) {
		Integer userid = passwordDTO.getUserid();
		String inputPassword = passwordDTO.getPassword();
		
		String userPassword = userMapper.getPasswordByUserId(userid);
		
		boolean matches = passwordEncoder.matches(inputPassword, userPassword);
		
		if (matches) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.USER_PASSWORD_ERROR;
	}
	
	@Override
	public ResponseCode changePassword(PasswordDTO passwordDTO) {
		Integer userid = passwordDTO.getUserid();
		String inputPassword = passwordDTO.getPassword();
		
		String hashPass = passwordEncoder.encode(inputPassword);
		
		int cows = userMapper.updatePassword(userid, hashPass);
		if (cows > 0) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.ERROR;
	}
	
	@Override
	public ResponseCode updateUserPhone(ChangeInfoDTO changeInfoDTO) {
		Integer userid = changeInfoDTO.getUserid();
		String phone = changeInfoDTO.getPhone();
		int cows = userInfoMapper.updateUserPhoneByUserid(userid, phone);
		if (cows > 0) {
			return ResponseCode.SUCCESS;
		}
		return ResponseCode.ERROR;
	}
	
	@Override
	public PageBean<OrderVO> findMyOrders(PageDTO pageDTO) {
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		Integer userid = pageDTO.getUserid();
		
		int begin = (currentPage - 1) * pageSize;
		
		List<OrderVO> myOrders = orderMapper.findMyOrder(userid, begin, pageSize);
		int count = orderMapper.countMyOrder(userid);
		
		PageBean<OrderVO> pageBean = new PageBean<>();
		pageBean.setList(myOrders);
		pageBean.setTotal(count);
		return pageBean;
	}
	
	@Override
	public ResponseCode emailCheck(String email) {
		MyUser user = userMapper.getUserByEmail(email);
		if (user != null) {
			return ResponseCode.USERNAME_ALREADY_EXISTS;
		}
		return ResponseCode.SUCCESS;
	}
	
	@Override
	public String getUserMoney(Integer userid) {
		return userInfoMapper.getUserMoneyByUserid(userid);
	}
}
