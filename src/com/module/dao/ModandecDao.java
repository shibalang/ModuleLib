package com.module.dao;

import java.util.List;

import com.module.beans.Modandec;

public interface ModandecDao {

	public List<Modandec> selectByModuleId(int moduleId);
}
