package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.CategoriesOrm;

public class categories {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		CategoriesOrm e = new CategoriesOrm();
		e.setCategoryNameEng("Aliiiiiiiiii");
		CategoriesOrm p = (CategoriesOrm)session.get(CategoriesOrm.class, 14);
		e.setParentCategory(p);
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.clear();
		session.close();
	}

}


