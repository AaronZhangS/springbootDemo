package org.springboot.statement.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	/**
     * 新增用户
     */
	@Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
	int addUser(@Param("username") String username,@Param("password") String password);
	/**
	 * 用户登录
	 */
	@Select("select * from user where username = #{username} and password = #{password}")
	Map loginUser(@Param("username") String username,@Param("password") String password);
}
