package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.CategoriesDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.CategoriesOrm;
import com.shopping.to.CategoriesTo;

public class CategoriesDaoimpl implements CategoriesDao{

	public CategoriesTo insert(CategoriesTo categoriesTo) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Set the ORM
			CategoriesOrm categoriesOrm = new CategoriesOrm();
			categoriesOrm.setId(categoriesOrm.getId());
			categoriesOrm.setCategoryNameEng(categoriesTo.getCategoryNameEng());
			categoriesOrm.setCategoryNameHindi(categoriesTo.getCategoryNameHindi());
			categoriesOrm.setCategoryNameTamil(categoriesTo.getCategoryNameTamil());
			categoriesOrm.setCategoryNameTel(categoriesTo.getCategoryNameTel());
			categoriesOrm.setParentCategory(this.getCategoryById(categoriesTo.getParentCategory()));
			categoriesOrm.setRootCategory(this.getCategoryById(categoriesTo.getRootCategory()));
			categoriesOrm.setCreatedBy(new UserDaoimpl().getUserById(categoriesTo.getCreatedBy()));
			categoriesOrm.setCreatedDate(new Date());
			categoriesOrm.setModifiedBy(new UserDaoimpl().getUserById(categoriesTo.getModifiedBy()));
			categoriesOrm.setModifiedDate(new Date());
			
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(categoriesOrm);
			tx.commit();
			//Get the Updated Object from the DB
			categoriesTo = this.searchById(categoriesOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
		}
		return categoriesTo;
	}

	public CategoriesTo update(int id, CategoriesTo categoriesTo) {
		Session session = null;
		Transaction tx = null;
		CategoriesTo sendCategoriesTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			CategoriesOrm categoriesOrm = (CategoriesOrm)session.load(CategoriesOrm.class, new Integer(id));
			categoriesOrm.setId(categoriesOrm.getId());
			categoriesOrm.setCategoryNameEng(categoriesTo.getCategoryNameEng());
			categoriesOrm.setCategoryNameHindi(categoriesTo.getCategoryNameHindi());
			categoriesOrm.setCategoryNameTamil(categoriesTo.getCategoryNameTamil());
			categoriesOrm.setCategoryNameTel(categoriesTo.getCategoryNameTel());
			categoriesOrm.setParentCategory(this.getCategoryById(categoriesTo.getParentCategory()));
			categoriesOrm.setRootCategory(this.getCategoryById(categoriesTo.getRootCategory()));
			categoriesOrm.setModifiedBy(new UserDaoimpl().getUserById(categoriesTo.getModifiedBy()));
			categoriesOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendCategoriesTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			categoriesTo = null;
		}
		return sendCategoriesTo;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public CategoriesTo searchById(int id) {
		Session session = null;
		CategoriesTo categoriesTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			CategoriesOrm categoriesOrm = (CategoriesOrm) session.createCriteria(CategoriesOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			categoriesTo = new CategoriesTo();
			categoriesTo.setId(categoriesOrm.getId());
			categoriesTo.setCategoryNameEng(categoriesOrm.getCategoryNameEng());
			categoriesTo.setCategoryNameHindi(categoriesOrm.getCategoryNameHindi());
			categoriesTo.setCategoryNameTamil(categoriesOrm.getCategoryNameTamil());
			categoriesTo.setCategoryNameTel(categoriesOrm.getCategoryNameTel());
			categoriesTo.setParentCategory(categoriesOrm.getParentCategory().getId());
			categoriesTo.setRootCategory(categoriesOrm.getRootCategory().getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return categoriesTo;
	}

	public Collection<CategoriesTo> getAll() {
		Session session = null;
		ArrayList<CategoriesTo> lstCategoriesTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<CategoriesOrm> lstCategoriesOrm = (ArrayList<CategoriesOrm>) session.createCriteria(CategoriesOrm.class).list();
			CategoriesTo categoriesTo = null;
			lstCategoriesTo = new ArrayList<CategoriesTo>();
			for (CategoriesOrm categoriesOrm : lstCategoriesOrm) {
				//Set the Data to the To Object
				categoriesTo = new CategoriesTo();
				categoriesTo.setId(categoriesOrm.getId());
				categoriesTo.setCategoryNameEng(categoriesOrm.getCategoryNameEng());
				categoriesTo.setCategoryNameHindi(categoriesOrm.getCategoryNameHindi());
				categoriesTo.setCategoryNameTamil(categoriesOrm.getCategoryNameTamil());
				categoriesTo.setCategoryNameTel(categoriesOrm.getCategoryNameTel());
				categoriesTo.setParentCategory(categoriesOrm.getParentCategory().getId());
				categoriesTo.setRootCategory(categoriesOrm.getRootCategory().getId());
				//Add the Object to the Array List
				lstCategoriesTo.add(categoriesTo);
			}
			
			System.out.println("lstCategoriesTo:: "+lstCategoriesTo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstCategoriesTo;
	}

	public CategoriesOrm getCategoryById(int id) {
		Session session = null;
		CategoriesOrm categoryOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			categoryOrm = (CategoriesOrm) session.createCriteria(CategoriesOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return categoryOrm;
	}

}
