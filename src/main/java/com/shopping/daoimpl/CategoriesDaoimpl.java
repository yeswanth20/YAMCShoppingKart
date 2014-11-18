package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.shopping.dao.CategoriesDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.CategoriesOrm;
import com.shopping.to.CategoriesTo;

public class CategoriesDaoimpl implements CategoriesDao{

	public CategoriesTo insert(CategoriesTo categoriesTo, int userId) {
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
			categoriesOrm.setRootCategory(this.getCategoryById(this.getRootCategoryIdBasedOnParentCategoryId(categoriesTo.getParentCategory())));
			categoriesOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			categoriesOrm.setCreatedDate(new Date());
			categoriesOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
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

	public CategoriesTo update(int id, CategoriesTo categoriesTo, int userId) {
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
			categoriesOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
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
		boolean result = true;
		//Get Object
		CategoriesOrm categoriesOrm = this.getCategoryById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(categoriesOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			categoriesOrm = null;
		}
		
		return result;
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
				categoriesTo = this.setCategoriesOrm2To(categoriesOrm);
				//Add the Object to the Array List
				lstCategoriesTo.add(categoriesTo);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstCategoriesTo;
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
			categoriesTo = this.setCategoriesOrm2To(categoriesOrm);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return categoriesTo;
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

	public int getRootCategoryIdBasedOnParentCategoryId(int parentCategoryId) {
		int rootCategoryId = parentCategoryId;
		if (parentCategoryId != 0){
			//Get the record based on ID From DB
			CategoriesOrm categoriesOrm = this.getCategoryById(parentCategoryId);
			if (categoriesOrm.getRootCategory() != null){
				rootCategoryId = categoriesOrm.getRootCategory().getId();
			}
		}
		return rootCategoryId;
	}
	
	public CategoriesTo setCategoriesOrm2To(CategoriesOrm categoriesOrm){
		
		CategoriesTo categoriesTo = new CategoriesTo();
		categoriesTo.setId(categoriesOrm.getId());
		categoriesTo.setCategoryNameEng(categoriesOrm.getCategoryNameEng());
		categoriesTo.setCategoryNameHindi(categoriesOrm.getCategoryNameHindi());
		categoriesTo.setCategoryNameTamil(categoriesOrm.getCategoryNameTamil());
		categoriesTo.setCategoryNameTel(categoriesOrm.getCategoryNameTel());
		if (categoriesOrm.getParentCategory() != null){
			categoriesTo.setParentCategory(categoriesOrm.getParentCategory().getId());
		}
		if (categoriesOrm.getRootCategory() != null){
			categoriesTo.setRootCategory(categoriesOrm.getRootCategory().getId());
		}
		return categoriesTo;
		
	}
	
	
	public static void main(String[] args) {
		CategoriesDaoimpl implObj = new CategoriesDaoimpl();
		CategoriesTo categoriesTo = new CategoriesTo();
		categoriesTo = implObj.searchById(9);
		System.out.println(new Gson().toJson(categoriesTo));
	}
}
