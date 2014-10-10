package com.demo.hibernate;

import com.shopping.daoimpl.UnitDaoimpl;
import com.shopping.to.UnitsTo;

public class Units {
	
	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		System.out.println("hiiiiiiiiiiiii");
//		UnitsOrm e = new UnitsOrm();
//		e.setUnitName("Aliiiiiiiiii");
//		Transaction tx = session.beginTransaction();
//		session.save(e);
//		tx.commit();
		
		UnitDaoimpl daoimpl = new UnitDaoimpl();
//		daoimpl.search(20);
		UnitsTo to = new UnitsTo();
		to.setUnitName("khudrathasad");
//		daoimpl.update(10, to);
		daoimpl.insert(to);
//		daoimpl.getAll();
//		session.clear();
//		session.close();
		
		
	}

}


