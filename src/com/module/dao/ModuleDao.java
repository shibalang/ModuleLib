package com.module.dao;

import java.util.Collection;
import java.util.List;




import com.module.beans.Module;


public interface ModuleDao {

	public int addModule(Module module);
	
	public List<Module> selectAll();
	public List<Module> selectByAttribute(Module module);
	
	public Module selectById(int id);

	public List selectBysql(String sqlString,int pN,int pS);
	
	public List<Module> selectByMultilike(Module module);

	public List selectByProteinname(String key ,int pN,int pS);
	
	public int selectCountByProteinname(String key);
	public int selectCountBySql(String sqlString);
}
