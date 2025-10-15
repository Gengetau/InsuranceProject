package com.seiryo.util;

import com.seiryo.vo.UserVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName JwtUtil
 * @Description jwt工具类
 * @dateTime 14/10/2025 下午12：13
 */
public class JwtUtil {
	// 这是一个非常非常重要的密钥，不能告诉别人哦喵！
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	// Token 的有效时间，这里设置为7天喵
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7;
	
	/**
	 * @param userVO 登录成功的用户对象
	 * @return 生成的JWT Token字符串
	 * @MethodName: generateToken
	 * @Description: 为用户生成一个Token喵
	 */
	public static String generateToken(UserVO userVO) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userid", userVO.getUserid());
		claims.put("userEmail", userVO.getUserEmail());
		claims.put("userName", userVO.getUserName());
		
		return Jwts.builder()
				.setClaims(claims) // 把用户的重要信息放进去
				.setSubject(userVO.getUserEmail())
				.setIssuedAt(new Date(System.currentTimeMillis())) // 设置签发时间
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
				.signWith(SECRET_KEY) // 用我们的密钥签名
				.compact();
	}
	
	/**
	 * @param token 前端传来的Token
	 * @return Token中的信息
	 * @MethodName: parseToken
	 * @Description: 检验并解析Token喵
	 */
	public static Claims parseToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
}
