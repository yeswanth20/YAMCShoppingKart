package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.BrandOrm;

public class Brands {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		BrandOrm e = new BrandOrm();
		e.setBrandNameEng("brandNameEng");
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


