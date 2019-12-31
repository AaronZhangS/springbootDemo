package org.springboot.statement.controller;

import java.io.File;

import org.springboot.statement.objectstore.MinioObjectClient;
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
		File file = new File("/object_store_config.properties");
		MinioObjectClient.getInstance().saveFile(null, null);
		return "hello spring boot";
	}
}
