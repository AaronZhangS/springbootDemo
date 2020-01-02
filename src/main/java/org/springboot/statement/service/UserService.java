package org.springboot.statement.service;

import java.util.Map;

public interface UserService {
	/**
     * 新增用户
     */
	int addUser(String username,String password);
	/**
	 * 用户登录
	 */
	Map loginUser(String username,String password);
}
