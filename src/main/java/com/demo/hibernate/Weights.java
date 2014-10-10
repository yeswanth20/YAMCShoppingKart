package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.UnitsOrm;
import com.shopping.orm.WeightsOrm;

public class Weights {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		WeightsOrm e = new WeightsOrm();
		e.setWeightName("Aliiiiiiiiii");
		UnitsOrm u = (UnitsOrm)session.get(UnitsOrm.class, 1);
		e.setUnit(u);
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


