package com.seiryo.dao;

import com.seiryo.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserMapper
 * @Description 用户持久层接口
 * @dateTime 14/10/2025 上午11:59
 */
@Mapper
public interface UserMapper {
	/**
	 * @param email 邮箱
	 * @return MyUser对象 || null
	 * @MethodName: getUserByEmail
	 * @Description: 根据邮箱账号获取用户
	 */
	@Select("SELECT * FROM My_User WHERE User_Email = #{email} AND User_Status = 1;")
	MyUser getUserByEmail(@Param("email") String email);
	
	/**
	 * @param user 用户对象
	 * @MethodName: addNewUser
	 * @Description: 插入新用户
	 */
	void addNewUser(MyUser user);
	
	/**
	 * @param userid 用户id
	 * @return 返回加密后的密码
	 * @MethodName: getPasswordByUserId
	 * @Description: 获取账号密码（修改验证用）
	 */
	@Select("SELECT User_Password FROM My_User WHERE User_Id = #{id}")
	String getPasswordByUserId(@Param("id") Integer userid);
	
	/**
	 * @param userid   用户id
	 * @param password 哈希加密后的密码
	 * @return 受影响的行数
	 * @MethodName: updatePassword
	 * @Description: 修改密码
	 */
	@Update("UPDATE My_User SET User_Password = #{password} WHERE User_Id = #{id}")
	int updatePassword(@Param("id") Integer userid, @Param("password") String password);
}
