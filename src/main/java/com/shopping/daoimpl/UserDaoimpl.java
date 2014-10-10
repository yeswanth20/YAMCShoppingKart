package com.shopping.daoimpl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.UserOrm;

public class UserDaoimpl {
	public UserOrm getUserById(int id) {
		Session session = null;
		UserOrm userOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			userOrm=(UserOrm) session.createCriteria(UserOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return userOrm;
	}
	
	public int getUserId(UserOrm userOrm) {
		return userOrm.getId();
	}

}
