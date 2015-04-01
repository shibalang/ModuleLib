package com.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.beans.Test;
import com.module.dao.TestDao;
import com.module.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao dao;
	
	@Override
	public boolean addTest(Test test) {
		
		int result=dao.addTest(test);
		System.out.println(result);
		if(result!=0)
		{
			return true;
		}
		
		return false;
	}

}
