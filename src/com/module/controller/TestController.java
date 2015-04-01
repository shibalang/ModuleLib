package com.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.module.beans.Test;
import com.module.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService service;
	
	@RequestMapping("hello")
	public void test()
	{
		System.out.println("hello world!");
		Test test=new Test();
		test.setTest("111");
		service.addTest(test);
	}
}
