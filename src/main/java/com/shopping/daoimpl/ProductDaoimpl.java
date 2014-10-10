package com.shopping.daoimpl;


import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.dao.ProductDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.ProductOrm;
import com.shopping.to.ProductTo;

public class ProductDaoimpl implements ProductDao{

	public ProductTo insert(ProductTo productTo) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ProductOrm productOrm = new ProductOrm();
			productOrm.setProductNameEng(productTo.getProductNameEng());
			productOrm.setProductNameHindi(productTo.getProductNameHindi());
			productOrm.setProductNameTamil(productTo.getProductNameTamil());
			productOrm.setProductNameTel(productTo.getProductNameTel());
			productOrm.setStockAvailable(productTo.isStockAvailable());
			
			
			tx = session.beginTransaction();
			session.persist(productOrm);
			tx.commit();
			productTo = this.searchById(productOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			
			session.clear();
			session.close();
			tx =null;
		}
		
		return productTo;
	}

	public ProductTo update(int id, ProductTo productTo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<ProductTo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductTo searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductOrm getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
