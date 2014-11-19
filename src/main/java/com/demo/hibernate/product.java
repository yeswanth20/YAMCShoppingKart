package com.demo.hibernate;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.daoimpl.ProductDaoimpl;
import com.shopping.orm.ProductUnitDetailsOrm;
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
//		productTo.setProductNameEng("Aliiiiiiiiii vvvvvvv");
//		
//		ProductUnitDetailsTo productUnitDetailsTo = new ProductUnitDetailsTo();
//		productUnitDetailsTo.setPrice(5.36);
//		productUnitDetailsTo.setUnit(10);
//		productUnitDetailsTo.setDiscountType(10);
//		productUnitDetailsTo.setWeight(10);
//		
//		productTo.setProductNameTel("productNameTel");
//		productTo.setBrand(151);
//		
//		productTo.getProductUnitDetails().add(productUnitDetailsTo);	
		
		
		productTo.setProductNameEng("1");
		productTo.setProductNameHindi("2");
		productTo.setProductNameTamil("3");
		productTo.setProductNameTel("4");
		productTo.setStockAvailable(true);
		productTo.setBrand(1);


		
		ProductUnitDetailsTo productUnitDetailsTo = new ProductUnitDetailsTo();
		productUnitDetailsTo.setUnit(1);
		productUnitDetailsTo.setWeight(1);
		productUnitDetailsTo.setDiscountType(1);
		productUnitDetailsTo.setDiscountValue(21);
		productUnitDetailsTo.setPrice(2150.5);
		productTo.getProductUnitDetails().add(productUnitDetailsTo);
		
		
		
		ShoppingCartFactory.getProductDao().insert(productTo,12);
//		productTo = daoimpl.update(4, productTo, 10);
//		System.out.println("--"+productTo.getProductNameEng());
		
	
	}

}


