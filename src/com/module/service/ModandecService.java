package com.module.service;

import java.util.List;

import com.module.beans.Modandec;


public interface ModandecService {

	public List<Modandec> selectByModuleId(String moduleId);
}
