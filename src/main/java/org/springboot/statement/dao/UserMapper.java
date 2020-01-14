package org.springboot.statement.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	/**
	 * 新增用户
	 */
	@Insert("INSERT INTO user(username, password, email, code) VALUES(#{username}, #{password}, #{email}, #{code})")
	int addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email,
			@Param("code") String code);

	/**
	 * 用户登录
	 */
	@Select("select * from user where username = #{username} and password = #{password}")
	Map loginUser(@Param("username") String username, @Param("password") String password);

	/**
	 * 更新用户
	 */
	@Update("update user set state = 1 where code = #{code}")
	int updateUser(@Param("code") String code);
	
	/**
	 * 查询所有用户
	 */
	@Select("select * from user")
	Map allUser();
}
