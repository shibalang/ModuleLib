package com.module.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.module.beans.Modandec;
import com.module.beans.Module;
import com.module.beans.Test;
import com.module.dao.ModandecDao;
import com.module.dao.TestDao;
import com.module.utils.DBUtils;

@Repository
public class ModandecDaoImpl implements ModandecDao {

	private static SessionFactory sessionFactory; 

	public ModandecDaoImpl(){
		ModandecDaoImpl.sessionFactory=DBUtils.getSessionFactory();
	}

	@Override
	public List<Modandec> selectByModuleId(int moduleId) {
		List<Modandec> moduleList=null;
		Session session = sessionFactory.openSession();  
        String hql = "from Modandec where moduleid="+moduleId;  
        Query query = session.createQuery(hql);  
        moduleList =  query.list(); 
        session.close();
		return moduleList;
	}

}
