package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.DiscountTypeOrm;

public class DiscountType {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		DiscountTypeOrm e = new DiscountTypeOrm();
		e.setDiscountName("Aliiiiiiiiii");
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


