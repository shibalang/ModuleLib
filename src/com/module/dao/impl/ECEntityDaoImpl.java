package com.module.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.module.beans.ECEntity;
import com.module.beans.Module;
import com.module.beans.Test;
import com.module.dao.ECEntityDao;
import com.module.dao.TestDao;
import com.module.utils.DBUtils;

@Repository
public class ECEntityDaoImpl implements ECEntityDao {

	private static SessionFactory sessionFactory;

	public ECEntityDaoImpl()
	{
		ECEntityDaoImpl.sessionFactory=DBUtils.getSessionFactory();
	}
	@Override
	public ECEntity selectById(String id) {
		
		Session session = sessionFactory.openSession();  
        String hql = "from ECEntity where entry='"+id+"'";  
        Query query = session.createQuery(hql);  
        ECEntity ecEntity = (ECEntity) query.uniqueResult(); 
        session.close();
		return ecEntity;
	} 
	
	
}
