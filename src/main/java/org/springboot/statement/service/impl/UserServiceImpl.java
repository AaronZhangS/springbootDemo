package org.springboot.statement.service.impl;

import java.util.Map;

import org.springboot.statement.dao.UserMapper;
import org.springboot.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int addUser(String username, String password, String email, String code) {
		return userMapper.addUser(username, password, email, code);
	}

	@Override
	public Map loginUser(String username, String password) {
		return userMapper.loginUser(username, password);
	}

	@Override
	public int updateUser(String code) {
		return userMapper.updateUser(code);
	}

}
