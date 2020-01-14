package org.springboot.test;

import org.springboot.statement.Application;
import org.springboot.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = Application.class)
public class TestNg extends AbstractTestNGSpringContextTests{

	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		System.out.println("testng");
		System.out.println(userService.returnStr());
	}
}
