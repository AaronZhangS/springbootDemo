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
	public int addUser(String username, String password) {
		return userMapper.addUser(username, password);
	}

	@Override
	public Map loginUser(String username, String password) {
		return userMapper.loginUser(username, password);
	}

}
