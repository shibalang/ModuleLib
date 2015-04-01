package com.module.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.module.beans.Module;;


public interface ModuleService {

	public boolean addModule(Module module);
	
	public List<Module> selectByAttribute(Module module);
	public List<Module> selectAll();
	public List selectBySql(String sql,int pN,int pS);
	
	public Module selectById(String idString);

	public List search_Vague(String key,int pN,int pS);
	public int search_Vague_Count(String key);
	public int search_SQL_Count(String sql); //精确查找查询条目总数

	public HSSFWorkbook getExcelById(String id);

	public Document getPdfById(String id);
	
}
