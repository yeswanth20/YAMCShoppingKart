package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		Session session = null;
		ArrayList<ProductTo> lstProductTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<ProductOrm> lstProductOrm = (ArrayList<ProductOrm>) session.createCriteria(ProductOrm.class).list();
			ProductTo productTo = null;
			lstProductTo = new ArrayList<ProductTo>();
			for (ProductOrm productOrm : lstProductOrm) {
				//Set the Data to the To Object
				productTo = new ProductTo();
				productTo.setId(productOrm.getId());
				productTo.setProductNameEng(productOrm.getProductNameEng());
				productTo.setProductNameHindi(productOrm.getProductNameHindi());
				productTo.setProductNameTamil(productOrm.getProductNameTamil());
				productTo.setProductNameTel(productOrm.getProductNameTel());
				productTo.setStockAvailable(productOrm.isStockAvailable());
				productTo.setBrand(productOrm.getBrand().getId());


				ProductUnitDetailsTo productUnitDetailsTo = null;
				for (ProductUnitDetailsOrm productUnitDetailsOrm : productOrm.getProductUnitDetails()) {
					productUnitDetailsTo = new ProductUnitDetailsTo();
					productUnitDetailsTo.setUnit(productUnitDetailsOrm.getUnit().getId());
					productUnitDetailsTo.setWeight(productUnitDetailsOrm.getWeight().getId());
					productUnitDetailsTo.setDiscountType(productUnitDetailsOrm.getDiscountType().getId());
					productUnitDetailsTo.setDiscountValue(productUnitDetailsOrm.getDiscountValue());
					productUnitDetailsTo.setPrice(productUnitDetailsOrm.getPrice());
					productUnitDetailsTo.setProduct(productTo.getId());
					productTo.getProductUnitDetails().add(productUnitDetailsTo);


				}
				//Add the Object to the Array List
				lstProductTo.add(productTo);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstProductTo;
	}

	public ProductTo searchById(int id) {
		Session session = null;
		ProductTo productTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			ProductOrm productOrm = (ProductOrm) session.createCriteria(ProductOrm.class).add(Restrictions.eq("id", id)).uniqueResult();

			//Set the Data to the To Object
			productTo = new ProductTo();
			productTo.setId(productOrm.getId());
			productTo.setProductNameEng(productOrm.getProductNameEng());
			productTo.setProductNameHindi(productOrm.getProductNameHindi());
			productTo.setProductNameTamil(productOrm.getProductNameTamil());
			productTo.setProductNameTel(productOrm.getProductNameTel());
			productTo.setStockAvailable(productOrm.isStockAvailable());
			productTo.setBrand(productOrm.getBrand().getId());


			ProductUnitDetailsTo productUnitDetailsTo = null;
			for (ProductUnitDetailsOrm productUnitDetailsOrm : productOrm.getProductUnitDetails()) {
				productUnitDetailsTo = new ProductUnitDetailsTo();
				productUnitDetailsTo.setUnit(productUnitDetailsOrm.getUnit().getId());
				productUnitDetailsTo.setWeight(productUnitDetailsOrm.getWeight().getId());
				productUnitDetailsTo.setDiscountType(productUnitDetailsOrm.getDiscountType().getId());
				productUnitDetailsTo.setDiscountValue(productUnitDetailsOrm.getDiscountValue());
				productUnitDetailsTo.setPrice(productUnitDetailsOrm.getPrice());
				productUnitDetailsTo.setProduct(productTo.getId());
				productTo.getProductUnitDetails().add(productUnitDetailsTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return productTo;
	}

	public ProductOrm getProductById(int id) {
		Session session = null;
		ProductOrm productOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			productOrm = (ProductOrm) session.createCriteria(ProductOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return productOrm;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}




}
