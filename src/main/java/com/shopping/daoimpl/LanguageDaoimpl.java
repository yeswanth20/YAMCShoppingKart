package com.shopping.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.LanguageDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.LanguageOrm;
import com.shopping.to.LanguageTo;

public class LanguageDaoimpl implements LanguageDao {

	public LanguageTo insert(LanguageTo languageTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			LanguageOrm languageOrm = new LanguageOrm();
			languageOrm.setLanguageName(languageTo.getLanguageName());
			languageOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			languageOrm.setCreatedDate(new Date());
			languageOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			languageOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(languageOrm);
			tx.commit();
			//Get the Updated Object from the DB
			languageTo=null;
			languageTo = this.searchById(languageOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return languageTo;
	}

	public LanguageTo update(int id, LanguageTo languageTo, int userId) {
		Session session = null;
		Transaction tx = null;
		LanguageTo sendLanguageTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			LanguageOrm languageOrm = (LanguageOrm)session.load(LanguageOrm.class, new Integer(id));
			languageOrm.setLanguageName(languageTo.getLanguageName());
			languageOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			languageOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendLanguageTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			languageTo = null;
		}
		return sendLanguageTo;
	}

	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		LanguageOrm languageOrm = this.getLanguageById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(languageOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			languageOrm = null;
		}
		
		return result;
	}

	public Collection<LanguageTo> getAll() {
		Session session = null;
		ArrayList<LanguageTo> lstlanguageTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<LanguageOrm> lstLanguageOrm = (ArrayList<LanguageOrm>) session.createCriteria(LanguageOrm.class).list();
			LanguageTo languageTo = null;
			lstlanguageTo = new ArrayList<LanguageTo>();
			for (LanguageOrm languageOrm : lstLanguageOrm) {
				//Set the Data to the To Object
				languageTo = new LanguageTo();
				languageTo.setId(languageOrm.getId());
				languageTo.setLanguageName(languageOrm.getLanguageName());
				//Add the Object to the Array List
				lstlanguageTo.add(languageTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstlanguageTo;
	}

	public LanguageTo searchById(int id) {
		Session session = null;
		LanguageTo languageTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			LanguageOrm languageOrm = (LanguageOrm) session.createCriteria(LanguageOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			languageTo = new LanguageTo();
			languageTo.setId(languageOrm.getId());
			languageTo.setLanguageName(languageOrm.getLanguageName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return languageTo;
	}
	
	public LanguageOrm getLanguageById(int id) {
		Session session = null;
		LanguageOrm languageOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			languageOrm = (LanguageOrm) session.createCriteria(LanguageOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return languageOrm;
	}
	
}
