package com.module.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.module.beans.Test;
import com.module.dao.TestDao;

@Repository
public class TestDaoImpl implements TestDao {

	private static SessionFactory sessionFactory; 
	
	@Override
	public int addTest(Test test) {
		int result = 0;
	    Session s = null;
		Transaction t = null;
		try {  
            
            /** �˷�����Hibernate4�б����Ϊ��ʱ */  
            // sessionFactory = new Configuration().configure().buildSessionFactory();  
  
            /**Hibernate4ȡ��SessionFactory�ķ��� */  
            Configuration cfg = new Configuration().configure();  
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
  
        
    	
    	
    			// ׼������

    			s = sessionFactory.openSession();
    			t = s.beginTransaction();
    			result = (Integer) s.save(test);
    			System.out.println(result);
    			t.commit();
        } catch (Exception err) {
			//t.rollback();
			err.printStackTrace();
		} finally {
			s.close();
		}
		return result;
	}

}
