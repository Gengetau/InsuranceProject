package com.seiryo.dao;

import com.seiryo.pojo.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Gengetsu
 * @version v1.0
 * @ClassName UserInfoMapper
 * @Description 用户信息持久层接口
 * @dateTime 14/10/2025 下午1:47
 */
@Mapper
public interface UserInfoMapper {
	/**
	 * @param myUserInfo 用户信息对象
	 * @return 受影响的行数
	 * @MethodName: addNewUserInfo
	 * @Description: 新增用户信息表
	 */
	int addNewUserInfo(MyUserInfo myUserInfo);
	
	/**
	 * @param userid 用户id
	 * @return MyUserInfo
	 * @MethodName: getUserInfoByUserid
	 * @Description: 根据userid查询详细个人信息
	 */
	@Select("SELECT * FROM My_User_Info WHERE User_Id = #{id}")
	MyUserInfo getUserInfoByUserid(@Param("id") Integer userid);
	
	/**
	 * @param userid 用户id
	 * @return 返回余额
	 * @MethodName: getUserMoneyByUserid
	 * @Description: 查询余额
	 */
	@Select("SELECT User_Money FROM My_User_Info WHERE User_Id = #{id};")
	String getUserMoneyByUserid(@Param("id") Integer userid);
	
	/**
	 * @param money 存入的余额（业务层计算后转化为String类型存入！！）
	 * @return 受影响的行数
	 * @MethodName: updateUserMoneyByUserid
	 * @Description: 购买后修正余额 || 充值
	 */
	@Update("UPDATE My_User_Info SET User_Money = #{money} WHERE User_Id = #{id}")
	int updateUserMoneyByUserid(@Param("id") Integer userid, @Param("money") String money);
	
	/**
	 * @param userid 用户id
	 * @param phone  联系电话
	 * @return 受影响的行数
	 * @MethodName: updateUserPhoneByUserid
	 * @Description: 修改联系号码
	 */
	@Update("UPDATE My_User_Info SET User_Phone = #{phone} WHERE User_Id = #{id}")
	int updateUserPhoneByUserid(@Param("id") Integer userid, @Param("phone") String phone);
}
