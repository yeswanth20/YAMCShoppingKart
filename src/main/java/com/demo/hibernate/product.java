package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.ProductOrm;
import com.shopping.orm.ProductUnitDetailsOrm;

public class product {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		ProductOrm e = new ProductOrm();
		e.setProductNameEng("Aliiiiiiiiii");
		
		ProductUnitDetailsOrm productUnitDetailsOrm = new ProductUnitDetailsOrm();
		productUnitDetailsOrm.setPrice(5.36);
		e.getProductUnitDetails().add(productUnitDetailsOrm);
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


