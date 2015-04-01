package com.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.beans.Modandec;
import com.module.beans.Module;
import com.module.beans.Test;
import com.module.dao.ModandecDao;
import com.module.dao.ModuleDao;
import com.module.dao.TestDao;
import com.module.service.ModandecService;
import com.module.service.ModuleService;
import com.module.service.TestService;

@Service
public class ModandecServiceImpl implements ModandecService {

	@Autowired
	private ModandecDao modandecDao;
	
	
	@Override
	public List<Modandec> selectByModuleId(String moduleId) {
		
		int id=Integer.valueOf(moduleId);
		
		
		return modandecDao.selectByModuleId(id);
	}



}
