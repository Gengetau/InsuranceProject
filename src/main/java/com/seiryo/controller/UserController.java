package com.seiryo.controller;

import com.seiryo.dto.*;
import com.seiryo.enums.ResponseCode;
import com.seiryo.service.UserService;
import com.seiryo.util.JwtUtil;
import com.seiryo.util.Result;
import com.seiryo.vo.OrderVO;
import com.seiryo.vo.PageBean;
import com.seiryo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserController
 * @Description 用户视图层控制器
 * @dateTime 14/10/2025 下午12:22
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	// 登录接口
	@PostMapping("/login")
	public Result login(@RequestBody LoginDTO loginDTO) {
		Map<String, Object> map = userService.login(loginDTO);
		UserVO loginUser = (UserVO) map.get("user");
		ResponseCode response = (ResponseCode) map.get("status");
		int code = response.getCode();
		String message = response.getMessage();
		if (loginUser != null) {
			// 登录成功，生成Token！
			String token = JwtUtil.generateToken(loginUser);
			// 把Token和一些基本用户信息返回给前端
			Map<String, Object> data = new HashMap<>();
			data.put("token", token);
			data.put("userInfo", loginUser);
			// 返回响应
			return Result.success(data);
		} else {
			return Result.error(code, message);
		}
	}
	
	// 注册接口
	@PostMapping("/register")
	public Result register(@RequestBody RegisterDTO registerDTO) {
		ResponseCode response = userService.register(registerDTO);
		int code = response.getCode();
		String message = response.getMessage();
		return Result.info(code, message);
	}
	
	// 充值接口
	@PostMapping("/charge")
	public Result charge(@RequestBody ChargeMoneyDTO chargeMoneyDTO) {
		ResponseCode responseCode = userService.chargeMoney(chargeMoneyDTO);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
	
	// 密码验证接口
	@PostMapping("/check")
	public Result checkPassword(@RequestBody PasswordDTO passwordDTO) {
		ResponseCode responseCode = userService.passwordCheck(passwordDTO);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
	
	// 密码修改接口
	@PostMapping("/change")
	public Result changePassword(@RequestBody PasswordDTO passwordDTO) {
		ResponseCode responseCode = userService.changePassword(passwordDTO);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
	
	// 手机号修改接口
	@PostMapping("/update")
	public Result updateUserPhone(@RequestBody ChangeInfoDTO changeInfoDTO) {
		ResponseCode responseCode = userService.updateUserPhone(changeInfoDTO);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
	
	// 查询我的订单接口
	@PostMapping("/order")
	public Result findMyOrders(@RequestBody PageDTO pageDTO) {
		PageBean<OrderVO> myOrders = userService.findMyOrders(pageDTO);
		if (myOrders != null) {
			return Result.success(myOrders);
		}
		return Result.error();
	}
	
	// 注册邮箱即时校验
	@PostMapping("/email")
	public Result emailCheck(@RequestParam("email") String email) {
		ResponseCode responseCode = userService.emailCheck(email);
		int code = responseCode.getCode();
		String message = responseCode.getMessage();
		return Result.info(code, message);
	}
	
	// 查询用户余额
	@GetMapping("/money")
	public Result getUserMoney(@RequestParam("userid") Integer userid) {
		String userMoney = userService.getUserMoney(userid);
		return Result.success(userMoney);
	}
}
