package org.springboot.statement.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserService {
	/**
        * 新增用户
     */
	int addUser(String username,String password, String email, String code);
	/**
	 * 用户登录
	 */
	Map loginUser(String username,String password);
	/**
	 * 更新用户
	 */
	int updateUser(String code);
	/**
	 * 所有用户
	 */
	Map allUser();
	/**
	 * testng
	 */
	String returnStr();
}
