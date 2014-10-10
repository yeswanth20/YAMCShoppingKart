package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.ProductUnitDetailsOrm;

public class ProductPriceDetails {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		ProductUnitDetailsOrm e = new ProductUnitDetailsOrm();
		e.setPrice(5.5);
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


