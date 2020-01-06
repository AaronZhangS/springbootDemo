package org.springboot.statement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springboot.statement.dao.TeamMapper;
import org.springboot.statement.model.Team;
import org.springboot.statement.service.impl.UserServiceImpl;
import org.springboot.statement.util.CodeUtil;
import org.springboot.statement.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String hello() {
		return "hello spring boot";
	}

	@RequestMapping("/minio")
	@ResponseBody
	public List<Team> minio() {
		return teamMapper.selectAll();
	}

	@RequestMapping("/login")
	public String login() {
		return "Login.html";
	}

	@RequestMapping("/regist")
	public String regist() {
		return "Regist.html";
	}

	@RequestMapping("/failure")
	public String failure() {
		return "Failure.html";
	}

	@RequestMapping("/success")
	public String success() {
		return "Success.html";
	}

	@RequestMapping("/index")
	public String index() {
		return "Index.html";
	}

	@RequestMapping("/regist/verify")
	@ResponseBody
	public int registVerify(HttpServletRequest request) {
		int state = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		// 利用正则表达式（可改进）验证邮箱是否符合邮箱的格式
		if (!email.matches("^\\w+@(\\w+\\.)+\\w+$")) {
			return state;
		} else {
			String code = CodeUtil.generateUniqueCode();
			state = userServiceImpl.addUser(username, password, email, code);
			new Thread(new MailUtil(email, code)).run();
		}
		return state;
	}

	@GetMapping("/regist/verified")
	public String registVerified(HttpServletRequest request) {
		int state = 0;
		String code = request.getParameter("code");
		// 更新user表
		state = userServiceImpl.updateUser(code);
		if (state > 0) {
			return "forward:/success";
		} else {
			System.out.println("in");
			return "forward:/failure";
		}
	}

	@RequestMapping("/login/verify")
	@ResponseBody
	public int loginVerify(HttpServletRequest request) {
		int statu = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Map map = userServiceImpl.loginUser(username, password);
		if (map != null && map.get("username") != null) {
			if (map.get("state").toString().equals("0")) {
				statu = 2;
			} else {
				statu = 1;
			}
		}
		return statu;
	}
}
