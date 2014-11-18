package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.DiscountTypeDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.DiscountTypeOrm;
import com.shopping.to.DiscountTypeTo;

public class DiscountTypeDaoimpl implements DiscountTypeDao{
	public DiscountTypeTo insert(DiscountTypeTo discountTypeTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			DiscountTypeOrm discountTypeOrm = new DiscountTypeOrm();
			
			discountTypeOrm.setDiscountName(discountTypeTo.getDiscountName());
			discountTypeOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			discountTypeOrm.setCreatedDate(new Date());
			discountTypeOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			discountTypeOrm.setModifiedDate(new Date());

			tx = session.beginTransaction();
			session.save(discountTypeOrm);
			tx.commit();
			discountTypeTo = this.searchById(discountTypeOrm.getId());
		} catch (Exception e) {
			tx.rollback();
		} finally{
			
			session.clear();
			session.close();
			tx =null;
		}

		return discountTypeTo;
	}

	public DiscountTypeTo update(int id, DiscountTypeTo discountTypeTo, int userId) {
		Session session = null;
		Transaction tx = null;
		DiscountTypeTo  discountTypeTo2= null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			//Update the ORM
			DiscountTypeOrm  discountTypeOrm = (DiscountTypeOrm)session.load(DiscountTypeOrm.class, new Integer(id));

			discountTypeOrm.setDiscountName(discountTypeTo.getDiscountName());
			discountTypeOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			discountTypeOrm.setModifiedDate(new Date());


			//Commit the Transaction
			tx.commit();

			//Get the Updated Object from the DB
			discountTypeTo2 = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			discountTypeTo = null;
		}
		return discountTypeTo2;
	}



	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		DiscountTypeOrm  discountTypeOrm = this.getDiscountTypeById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(discountTypeOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			discountTypeOrm = null;
		}
		
		return result;
	}

	public DiscountTypeTo searchById(int id) {
		Session session = null;
		DiscountTypeTo discountTypeTo=null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			DiscountTypeOrm discountTypeOrm=(DiscountTypeOrm) session.createCriteria(DiscountTypeOrm.class).add(Restrictions.eq("id", id)).uniqueResult();

			//Set the Data to the To Object
			discountTypeTo=new DiscountTypeTo();
			discountTypeTo.setId(discountTypeOrm.getId());
			discountTypeTo.setDiscountName(discountTypeOrm.getDiscountName());
			
			//		discountTypeTo.setStatusMsg(discountTypeOrm.gets);

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return discountTypeTo;
	}

	public Collection<DiscountTypeTo> getAll() {
		Session session = null;
		ArrayList<DiscountTypeTo>  lstDiscountTypeTo= null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<DiscountTypeOrm> discountTypeOrms = (ArrayList<DiscountTypeOrm>) session.createCriteria(DiscountTypeOrm.class).list();
			DiscountTypeTo discountTypeTo = null;
			lstDiscountTypeTo = new ArrayList<DiscountTypeTo>();
			for (DiscountTypeOrm discountTypeOrm : discountTypeOrms) {
				//Set the Data to the To Object

				discountTypeTo=new DiscountTypeTo();
				discountTypeTo.setId(discountTypeOrm.getId());
				discountTypeTo.setDiscountName(discountTypeOrm.getDiscountName());
				//			discountTypeTo.setStatusMsg(discountTypeOrm.get);

				//Add the Object to the Array List
				lstDiscountTypeTo.add(discountTypeTo);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstDiscountTypeTo;
	}
	
	public DiscountTypeOrm getDiscountTypeById(int id) {
		Session session = null;
		DiscountTypeOrm discountTypeOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			discountTypeOrm = (DiscountTypeOrm) session.createCriteria(DiscountTypeOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return discountTypeOrm;
	}

}
