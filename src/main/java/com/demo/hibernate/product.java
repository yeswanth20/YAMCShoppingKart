package com.demo.hibernate;

import com.shopping.daoimpl.ProductDaoimpl;
import com.shopping.to.ProductTo;
import com.shopping.to.ProductUnitDetailsTo;

public class product {
	
	public static void main(String[] args) {
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hiiiiiiiiiiiii");
		ProductOrm e = new ProductOrm();
		e.setProductNameEng("Aliiiiiiiiii");
		session.save(e);
		ProductUnitDetailsOrm productUnitDetailsOrm = new ProductUnitDetailsOrm();
		productUnitDetailsOrm.setPrice(5.36);
		e.getProductUnitDetails().add(productUnitDetailsOrm);
		session.persist(productUnitDetailsOrm);
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.clear();
		session.close();*/
	
		
		ProductTo productTo = new ProductTo();
		productTo.setProductNameEng("Aliiiiiiiiii");
		
		ProductUnitDetailsTo productUnitDetailsTo = new ProductUnitDetailsTo();
		productUnitDetailsTo.setPrice(5.36);
		productTo.getProductUnitDetails().add(productUnitDetailsTo);	
		
		ProductDaoimpl daoimpl = new ProductDaoimpl();
		daoimpl.insert(productTo,12);
	
	}

}


