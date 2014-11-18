package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.CityDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.CityOrm;
import com.shopping.to.CityTo;

public class CityDaoimpl implements CityDao{

	public CityTo insert(CityTo cityTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			CityOrm cityOrm = new CityOrm();
			cityOrm.setCityName(cityTo.getCityName());
			cityOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			cityOrm.setCreatedDate(new Date());
			cityOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			cityOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(cityOrm);
			tx.commit();
			//Get the Updated Object from the DB
			cityTo=null;
			cityTo = this.searchById(cityOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return cityTo;
	}

	public CityTo update(int id, CityTo cityTo, int userId) {
		Session session = null;
		Transaction tx = null;
		CityTo sendCityTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			CityOrm cityOrm = (CityOrm)session.load(CityOrm.class, new Integer(id));
			cityOrm.setCityName(cityTo.getCityName());
			cityOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			cityOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendCityTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			cityTo = null;
		}
		return sendCityTo;
	}

	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		CityOrm cityOrm = this.getCityById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(cityOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			cityOrm = null;
		}
		
		return result;
	}

	public Collection<CityTo> getAll() {
		Session session = null;
		ArrayList<CityTo> lstcityTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<CityOrm> lstCityOrm = (ArrayList<CityOrm>) session.createCriteria(CityOrm.class).list();
			CityTo cityTo = null;
			lstcityTo = new ArrayList<CityTo>();
			for (CityOrm cityOrm : lstCityOrm) {
				//Set the Data to the To Object
				cityTo = new CityTo();
				cityTo.setId(cityOrm.getId());
				cityTo.setCityName(cityOrm.getCityName());
				//Add the Object to the Array List
				lstcityTo.add(cityTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstcityTo;
	}

	public CityTo searchById(int id) {
		Session session = null;
		CityTo cityTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			CityOrm cityOrm = (CityOrm) session.createCriteria(CityOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			cityTo = new CityTo();
			cityTo.setId(cityOrm.getId());
			cityTo.setCityName(cityOrm.getCityName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return cityTo;
	}
	
	public CityOrm getCityById(int id) {
		Session session = null;
		CityOrm cityOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			cityOrm = (CityOrm) session.createCriteria(CityOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return cityOrm;
	}
	
}
