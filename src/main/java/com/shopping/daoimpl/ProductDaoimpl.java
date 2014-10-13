package com.shopping.daoimpl;


import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.dao.ProductDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.ProductOrm;
import com.shopping.orm.ProductUnitDetailsOrm;
import com.shopping.to.ProductTo;
import com.shopping.to.ProductUnitDetailsTo;

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
			productOrm.setBrand(new BrandDaoimpl().getBrandById(productTo.getBrand()));
			productOrm.setCreatedBy(productTo.getCreatedBy());
			productOrm.setCreatedDate(new Date());
			productOrm.setModifiedBy(productTo.getModifiedBy());
			productOrm.setModifiedDate(new Date());
			//		session.save(productOrm);
			//		sproductOrm.setProductImage(productTo.getProductImage());
			ProductUnitDetailsOrm productUnitDetailsOrm = null;
			for (ProductUnitDetailsTo productUnitDetailsTo : productTo.getProductUnitDetails()) {
				productUnitDetailsOrm = new ProductUnitDetailsOrm();
				productUnitDetailsOrm.setUnit(new UnitDaoimpl().getUnitById(productUnitDetailsTo.getUnit()));
				productUnitDetailsOrm.setWeight(new WeightsDaoimpl().getWeightById(productUnitDetailsTo.getWeight()));
				productUnitDetailsOrm.setDiscountType(new DiscountTypeDaoimpl().getDiscountTypeById(productUnitDetailsTo.getDiscountType()));
				productUnitDetailsOrm.setDiscountValue(productUnitDetailsTo.getDiscountValue());
				productUnitDetailsOrm.setPrice(productUnitDetailsTo.getPrice());
				productUnitDetailsOrm.setCreatedBy(new UserDaoimpl().getUserById(productUnitDetailsTo.getCreatedBy()));
				productUnitDetailsOrm.setCreatedDate(new Date());
				productUnitDetailsOrm.setModifiedBy(new UserDaoimpl().getUserById(productUnitDetailsTo.getModifiedBy()));
				productUnitDetailsOrm.setModifiedDate(new Date());
				productUnitDetailsOrm.setProduct(productOrm);
				productOrm.getProductUnitDetails().add(productUnitDetailsOrm);


			}

			tx = session.beginTransaction();
			session.persist(productOrm);
			tx.commit();
			//		productTo = this.searchById(productOrm.getId());

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally{

			session.clear();
			session.close();
			tx =null;
		}

		return productTo;
	}

	public ProductTo update(int id, ProductTo productTo) {
		Session session = null;
		Transaction tx = null;
		try {
		//Get Session Factory
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
        //Parent Data
        ProductOrm productOrm = new ProductOrm();
		productOrm.setProductNameEng(productTo.getProductNameEng());
		productOrm.setProductNameHindi(productTo.getProductNameHindi());
		productOrm.setProductNameTamil(productTo.getProductNameTamil());
		productOrm.setProductNameTel(productTo.getProductNameTel());
		productOrm.setStockAvailable(productTo.isStockAvailable());
		productOrm.setBrand(new BrandDaoimpl().getBrandById(productTo.getBrand()));
		productOrm.setCreatedBy(productTo.getCreatedBy());
		productOrm.setCreatedDate(new Date());
		productOrm.setModifiedBy(productTo.getModifiedBy());
		productOrm.setModifiedDate(new Date());
//		session.save(productOrm);
//		sproductOrm.setProductImage(productTo.getProductImage());
		ProductUnitDetailsOrm productUnitDetailsOrm = null;
		for (ProductUnitDetailsTo productUnitDetailsTo : productTo.getProductUnitDetails()) {
			productUnitDetailsOrm = new ProductUnitDetailsOrm();
			productUnitDetailsOrm.setUnit(new UnitDaoimpl().getUnitById(productUnitDetailsTo.getUnit()));
			productUnitDetailsOrm.setWeight(new WeightsDaoimpl().getWeightById(productUnitDetailsTo.getWeight()));
			productUnitDetailsOrm.setDiscountType(new DiscountTypeDaoimpl().getDiscountTypeById(productUnitDetailsTo.getDiscountType()));
			productUnitDetailsOrm.setDiscountValue(productUnitDetailsTo.getDiscountValue());
			productUnitDetailsOrm.setPrice(productUnitDetailsTo.getPrice());
			productUnitDetailsOrm.setCreatedBy(new UserDaoimpl().getUserById(productUnitDetailsTo.getCreatedBy()));
			productUnitDetailsOrm.setCreatedDate(new Date());
			productUnitDetailsOrm.setModifiedBy(new UserDaoimpl().getUserById(productUnitDetailsTo.getModifiedBy()));
			productUnitDetailsOrm.setModifiedDate(new Date());
			productUnitDetailsOrm.setProduct(productOrm);
			productOrm.getProductUnitDetails().add(productUnitDetailsOrm);
			
			
		}
       //
		
		
       tx.commit();
       productTo = this.searchById(id);
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		finally{

			session.clear();
			session.close();
			tx =null;
		}
       
       
		return productTo;
	}

	public Collection<ProductTo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductTo searchById(int id) {
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
