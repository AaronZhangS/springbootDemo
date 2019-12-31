package org.springboot.statement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello spring boot";
    }
	
	@RequestMapping("/minio")
	@ResponseBody
	public String minio(){
		return "hello spring boot";
	}
}
