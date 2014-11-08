package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.UnitsDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.UnitsOrm;
import com.shopping.to.UnitsTo;

public class UnitDaoimpl implements UnitsDao{

	public UnitsTo insert(UnitsTo unitsTo,int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			UnitsOrm unitsOrm = new UnitsOrm();
			unitsOrm.setUnitName(unitsTo.getUnitName());
			unitsOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			unitsOrm.setCreatedDate(new Date());
			unitsOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			unitsOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(unitsOrm);
			tx.commit();
			//Get the Updated Object from the DB
			unitsTo=null;
			unitsTo = this.searchById(unitsOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return unitsTo;
	}

	public UnitsTo update(int id, UnitsTo unitsTo, int userId) {
		Session session = null;
		Transaction tx = null;
		UnitsTo sendUnitsTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			UnitsOrm unitsOrm = (UnitsOrm)session.load(UnitsOrm.class, new Integer(id));
			unitsOrm.setUnitName(unitsTo.getUnitName());
			unitsOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			unitsOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendUnitsTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			unitsTo = null;
		}
		return sendUnitsTo;
	}

	public UnitsTo searchById(int id) {
		Session session = null;
		UnitsTo unitsTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			UnitsOrm unitsOrm=(UnitsOrm) session.createCriteria(UnitsOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			unitsTo=new UnitsTo();
			unitsTo.setId(unitsOrm.getId());
			unitsTo.setUnitName(unitsOrm.getUnitName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return unitsTo;
	}

	public boolean delete(int id) {
		return false;
	}

	public Collection<UnitsTo> getAll() {
		Session session = null;
		ArrayList<UnitsTo> lstunitsTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<UnitsOrm> lstUnitsOrm = (ArrayList<UnitsOrm>) session.createCriteria(UnitsOrm.class).list();
			UnitsTo unitsTo = null;
			lstunitsTo = new ArrayList<UnitsTo>();
			for (UnitsOrm unitsOrm : lstUnitsOrm) {
				//Set the Data to the To Object
				unitsTo = new UnitsTo();
				unitsTo.setId(unitsOrm.getId());
				unitsTo.setUnitName(unitsOrm.getUnitName());
				//Add the Object to the Array List
				lstunitsTo.add(unitsTo);
			}
			
			System.out.println("lstunitsTo:: "+lstunitsTo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstunitsTo;
	}
	
	public UnitsOrm getUnitById(int id) {
		Session session = null;
		UnitsOrm unitsOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			unitsOrm=(UnitsOrm) session.createCriteria(UnitsOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return unitsOrm;
	}

}
