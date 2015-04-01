package com.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.beans.ECEntity;
import com.module.beans.Test;
import com.module.dao.ECEntityDao;
import com.module.dao.TestDao;
import com.module.service.ECEntityService;
import com.module.service.TestService;

@Service
public class ECEntityServiceImpl implements ECEntityService {

	@Autowired
	private ECEntityDao ecentityDao ;

	@Override
	public ECEntity selectById(String id) {
		
		return ecentityDao.selectById(id);
	}
	
}
