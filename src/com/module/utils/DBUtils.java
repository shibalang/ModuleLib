package com.module.utils;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.module.beans.ECEntity;
import com.module.beans.Modandec;
import com.module.beans.Module;
import com.module.dao.ModuleDao;
import com.module.dao.impl.ModuleDaoImpl;

/**
 * 数据库相关，主要用来导入数据等
 * 
 * @author 朝
 * 
 */
public class DBUtils {

	private static SessionFactory sessionFactory; 
	private static List errorList=new ArrayList();
	/**
	 * 初始化sessionFactory模块
	 */
	static{
		try
		{
			/**Hibernate4取得SessionFactory的方法 */  
			Configuration cfg = new Configuration().configure();  
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
			// 准备数据
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		testMultiLike();
//		 importData("files/final-uniprot-data-2015.3.4.xls");
//		//importData_KEGG("files/result_kegg_1.xls");
//		//importData_KEGG("files/result_kegg_2.xls");
//		//importData_KEGG("files/result_kegg_3.xls");
//		 
//		  FileWriter fw = null;
//		     try {   
//	  
//		            fw = new FileWriter("d:/errorList.txt");   
//		            for (int i = 0; i < errorList.size(); i++) {   
//		            
//		            	fw.write(errorList.get(i).toString()); 
//		            	
//		            	fw.write("\r\n");
//		            }   
//		            fw.close(); 
//		     }
//		     catch(Exception e){}
	}
	
	/**
	 * 测试moduleDao selectByMultilike接口
	 */
	public static void testMultiLike()
	{
		Module module=new Module();
		module.setProteinname("dehydrogenase");
		module.setGenename("TCM");
		ModuleDao dao=new ModuleDaoImpl();
		List list=dao.selectByMultilike(module);
		System.out.println("结果条数为："+list.size());
	}
	
	/**
	 * 向数据库中插入kegg的数据
	 */
	public static void importData_KEGG(String fileName) {

		ReadExcel readExcel = new ReadExcel();

		try {
			String[][] result = readExcel.readExcel(fileName);

			for (int i = 0; i < result.length; ++i) {
				ECEntity ecentity = new ECEntity();
				ecentity.setEntry(result[i][0]);
				ecentity.setEnzymename(result[i][1]);
				ecentity.setEcclass(result[i][2]);
				ecentity.setSysname(result[i][3]);
				ecentity.setReaction(result[i][4]);
				ecentity.setSubstrate(result[i][5]);
				ecentity.setProduct(result[i][6]);
				ecentity.setComment(result[i][7]);
				ecentity.setPathway(result[i][8]);
				ecentity.setOrthology(result[i][9]);
				saveData_KEGG(ecentity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将每一个传入的kegg数据分开保存
	 * @param ecentity
	 */
	static void saveData_KEGG(ECEntity ecentity)
	{
		
		Session s = null;
		
		try
		{
		
			// 准备数据
			s = sessionFactory.openSession();
			Transaction t = null;
			t = s.beginTransaction();
			s.save(ecentity);
			t.commit();
		}
		catch(ConstraintViolationException e)
		{
			System.out.println("插入数据失败（违反唯一约束），EC号为："+ecentity.getEntry());
		}
		catch(DataException e)
		{
			System.out.println("插入数据失败（单元数据异常），EC号为："+ecentity.getEntry());
		}
		finally
		{
		s.close();
		}
	}

	
	/**
	 * 将从文件中得到的数据存入数据库
	 * @param module
	 * @param ecnums
	 */
	static void saveData_MODULE(Module module,String ecnums)
	{
		Session s = null;
		int moduleid=-1;
		 List<String> tempList=getEcs(ecnums);
		try
		{	
			// 准备数据
			s = sessionFactory.openSession();
			Transaction t = null;
			t = s.beginTransaction();
			moduleid=(Integer) s.save(module);
			 if(tempList==null||tempList.isEmpty())
	    	 {}
	    	 else
	    	 {
	    		 Iterator<String> iterator=tempList.iterator();
	    		 while(iterator.hasNext())
	    		 {
	    			 String ec=iterator.next();
	    			 Modandec modandec=new Modandec();
	    			 modandec.setEcentry(ec);
	    			 modandec.setModuleid(moduleid);
	    			 s.save(modandec);
	    		 }
	    	 }
			t.commit();
		}
		catch(ConstraintViolationException e)
		{
			System.out.println("插入数据失败（违反唯一约束），UNIPROT号为："+module.getUniprot());
			errorList.add(module.getUniprot());
		}
		catch(DataException e)
		{
			System.out.println("插入数据失败（单元数据异常），UNIPROT号为："+module.getUniprot());
			errorList.add(module.getUniprot());
		}
		finally
		{
		s.close();
		}
	}
	
	/*
	 * 根据给定的字符串 得到里边所有的ec号
	 * 返回值为list    
	 */
	 private static List<String> getEcs(String ecs) {
		if(ecs==null||"".equals(ecs))
			return null;
		else
		{
			List<String> ecList=new ArrayList<String>();
			String ss[]=ecs.split(";");
			for(int i=0;i<ss.length;++i)
			{
				String s=ss[i];
				s=s.replaceAll(" ","");
				//if(!s.contains("-"))
				//{
					ecList.add(s);
				//}
			}
			return ecList;
		}
	}
	
	/**
	 * 向数据库导入数据
	 */
	public static void importData(String fileName) {
		ReadExcel readExcel = new ReadExcel();
		try {
			String[][] result = readExcel.readExcel(fileName);
			for(int i=0;i<result.length;++i)
			{
				Module module=new Module();
				module.setProteinname(result[i][0]);
				module.setGenename(result[i][1]);
				module.setGenestatus(result[i][2]);
				module.setExistence(result[0][3]);
				module.setFuncclassific(result[i][4]);
				module.setOriginalorganism(result[i][5]);
				module.setTaxonomicidentifier(result[i][6]);
				module.setTargetorganism(result[i][7]);
				module.setFlag(result[i][8]);
				module.setProteinsequence(result[i][9]);
			    module.setProteinlength(Integer.valueOf(result[i][10]));
				module.setMass(Double.valueOf(result[i][11]));
				module.setFunction(result[i][12]);
				module.setCatalyticactivity(result[i][13]);
				module.setCofactor(result[i][14]);
				module.setPathway(result[i][15]);
				module.setDnasequence(result[i][16]);
				module.setVector(result[i][17]);
				module.setRestrictionsite(result[i][18]);
				module.setConnway(result[i][19]);
				module.setSubcellloc(result[i][20]);
				module.setInteraction(result[i][21]);
				module.setStructure(result[i][22]);
				module.setUniprot(result[i][23]);
				module.setDdbj(result[i][24]);
				module.setEmbl(result[i][25]);
				module.setGenebank(result[i][26]);
				module.setRefseq(result[i][27]);
				module.setKegg(result[i][28]);
				module.setModulename_zh(result[i][29]);
				module.setModulename_en(result[i][30]);
				module.setStuff(result[i][31]);
				module.setNewgeneid(result[i][32]);
				Date now = new Date(); 
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				module.setSubmittdate(now);
				module.setEditdate(now);
				saveData_MODULE(module, result[i][33]);
				
			}
			} catch (Exception err) {
				err.printStackTrace();
			}
	}

}
