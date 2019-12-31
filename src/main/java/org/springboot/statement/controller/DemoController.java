package org.springboot.statement.controller;

import java.util.List;

import org.springboot.statement.dao.TeamMapper;
import org.springboot.statement.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@Autowired
	private TeamMapper teamMapper;
	
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
}
