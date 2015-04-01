package com.module.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.stereotype.Repository;

import com.module.beans.Modandec;
import com.module.beans.Module;
import com.module.dao.ModuleDao;
import com.module.utils.DBUtils;


@Repository
public class ModuleDaoImpl implements ModuleDao {

	private static SessionFactory sessionFactory;

	public ModuleDaoImpl(){
		ModuleDaoImpl.sessionFactory=DBUtils.getSessionFactory();
	}
	
	@Override
	public int addModule(Module module) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Module> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> selectByAttribute(Module module) {
		List<Module> moduleList=null;
		Session s = null;
		try
		{	
			// 准备数据
			s = sessionFactory.openSession();
			Transaction t = null;
			t = s.beginTransaction();
			Criteria criteria = s.createCriteria(Module.class);  
	        criteria.add(Example.create(module));// 注意 
	        moduleList=criteria.list();
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		s.close();
		}
		return moduleList;
	}

	@Override
	public Module selectById(int id) {
		
		Session session = sessionFactory.openSession();  
        String hql = "from Module where id="+id;  
        Query query = session.createQuery(hql);  
        Module module = (Module) query.uniqueResult(); 
		session.close();
		return module;
	}

	@Override
	public List selectBysql(String sql,int pN,int pS) {
		 int pageNo = pN; // 当前页数  
	     int pageSize = pS; // 每页显示条数
	     String sqlString="select id,proteinname,genename,originalorganism,targetorganism,funcclassific from Module where "+sql;
		
		Session session = sessionFactory.openSession(); 
		SQLQuery query = session.createSQLQuery(sqlString.toString());
		query.setFirstResult((pageNo - 1) * pageSize);  
        query.setMaxResults(pageSize);  
		List list=query.list();
		session.close();
		return list;
	}

	@Override
	public List<Module> selectByMultilike(Module module) {
		List<Module> moduleList=null;
		Session s = null;
		try
		{	
			// 准备数据
			s = sessionFactory.openSession();
			Criteria criteria = s.createCriteria(Module.class);  
			if(module.getSmbid()!=null)
	        criteria.add(Restrictions.like("smbid", module.getSmbid(), MatchMode.ANYWHERE));
	        criteria.add(Restrictions.like("proteinname", module.getProteinname(), MatchMode.ANYWHERE));
	        criteria.add(Restrictions.like("genename", module.getGenename(), MatchMode.ANYWHERE));
	        if(module.getEmbl()!=null)
	        criteria.add(Restrictions.like("embl", module.getEmbl(), MatchMode.ANYWHERE));
	        
	        moduleList=criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		s.close();
		}
		return moduleList;
	}

	@Override
	public List selectByProteinname(String key,int pN,int pS) {
		 int pageNo = pN; // 当前页数  
	     int pageSize = pS; // 每页显示条数
	     List list=null;
		Session session = sessionFactory.openSession(); 
		String sql="select id,proteinname,genename,originalorganism,targetorganism,funcclassific from Module where proteinname like '%"+key+"%' or genename like  '%"+key+"%' "
				+" or SMBID like  '%"+key+"%' "
				+" or FUNCTION like  '%"+key+"%' ";
		Query  query = session.createQuery(sql.toString());
		query.setFirstResult((pageNo - 1) * pageSize);  
        query.setMaxResults(pageSize);  
		//query.addEntity(Module.class);
		list=query.list();
		session.close();
		return list;
	}

	@Override
	public int selectCountByProteinname(String key) {
			Session session = sessionFactory.openSession(); 
			String sql1="select count(*) from Module where proteinname like '%"+key+"%' or genename like  '%"+key+"%' "
					+" or SMBID like  '%"+key+"%' "
					+" or FUNCTION like  '%"+key+"%' ";
			Query  query1 = session.createQuery(sql1.toString());
			//query.addEntity(Module.class);
			List list1=query1.list();
			int result= Integer.valueOf(list1.get(0).toString());
			session.close();
			return result;
	}

	@Override
	public int selectCountBySql(String sql) {
		Session session = sessionFactory.openSession(); 
		String sqlString="select count(*) from Module where "+sql;
		Query  query1 = session.createQuery(sqlString.toString());
		//query.addEntity(Module.class);
		List list1=query1.list();
		int result= Integer.valueOf(list1.get(0).toString());
		session.close();
		return result;
	} 
	
}
