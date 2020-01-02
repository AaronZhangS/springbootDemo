package org.springboot.statement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springboot.statement.dao.TeamMapper;
import org.springboot.statement.model.Team;
import org.springboot.statement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@Autowired
	private TeamMapper teamMapper;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello spring boot";
    }
	
	@RequestMapping("/minio")
	@ResponseBody
	public List<Team> minio(){
		return teamMapper.selectAll();
	}
	
	@RequestMapping("/login")
	public String login(){
		return "Login.html";
	}
	
	@RequestMapping("/regist")
	public String regist(){
		return "Regist.html";
	}
	
	@RequestMapping("/regist/verify")
	@ResponseBody
	public int registVerify(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		return userServiceImpl.addUser(username, password);
	}
	@RequestMapping("/login/verify")
	@ResponseBody
	public int loginVerify(HttpServletRequest request){
		int statu = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map map = userServiceImpl.loginUser(username, password);
		if(map != null && map.get("username")!=null) {
			System.out.println(map);
			statu = 1;
		}
		return statu;
	}
}
