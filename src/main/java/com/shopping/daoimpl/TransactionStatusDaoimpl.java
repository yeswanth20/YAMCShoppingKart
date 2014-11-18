package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.TransactionStatusDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.TransactionStatusOrm;
import com.shopping.to.TransactionStatusTo;

public class TransactionStatusDaoimpl implements TransactionStatusDao{

	public TransactionStatusTo insert(TransactionStatusTo transactionStatusTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			TransactionStatusOrm transactionStatusOrm = new TransactionStatusOrm();
			transactionStatusOrm.setStatusName(transactionStatusTo.getStatusName());
			transactionStatusOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			transactionStatusOrm.setCreatedDate(new Date());
			transactionStatusOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			transactionStatusOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(transactionStatusOrm);
			tx.commit();
			//Get the Updated Object from the DB
			transactionStatusTo=null;
			transactionStatusTo = this.searchById(transactionStatusOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return transactionStatusTo;
	}

	public TransactionStatusTo update(int id, TransactionStatusTo transactionStatusTo, int userId) {
		Session session = null;
		Transaction tx = null;
		TransactionStatusTo sendTransactionStatusTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			TransactionStatusOrm transactionStatusOrm = (TransactionStatusOrm)session.load(TransactionStatusOrm.class, new Integer(id));
			transactionStatusOrm.setStatusName(transactionStatusTo.getStatusName());
			transactionStatusOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			transactionStatusOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendTransactionStatusTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			transactionStatusTo = null;
		}
		return sendTransactionStatusTo;
	}

	public TransactionStatusTo searchById(int id) {
		Session session = null;
		TransactionStatusTo transactionStatusTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			TransactionStatusOrm transactionStatusOrm = (TransactionStatusOrm) session.createCriteria(TransactionStatusOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			transactionStatusTo = new TransactionStatusTo();
			transactionStatusTo.setId(transactionStatusOrm.getId());
			transactionStatusTo.setStatusName(transactionStatusOrm.getStatusName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return transactionStatusTo;
	}

	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		TransactionStatusOrm transactionStatusOrm = this.getTransactionStatusById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(transactionStatusOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			transactionStatusOrm = null;
		}
		
		return result;
	}

	public Collection<TransactionStatusTo> getAll() {
		Session session = null;
		ArrayList<TransactionStatusTo> lsttransactionStatusTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<TransactionStatusOrm> lstTransactionStatusOrm = (ArrayList<TransactionStatusOrm>) session.createCriteria(TransactionStatusOrm.class).list();
			TransactionStatusTo transactionStatusTo = null;
			lsttransactionStatusTo = new ArrayList<TransactionStatusTo>();
			for (TransactionStatusOrm transactionStatusOrm : lstTransactionStatusOrm) {
				//Set the Data to the To Object
				transactionStatusTo = new TransactionStatusTo();
				transactionStatusTo.setId(transactionStatusOrm.getId());
				transactionStatusTo.setStatusName(transactionStatusOrm.getStatusName());
				//Add the Object to the Array List
				lsttransactionStatusTo.add(transactionStatusTo);
			}
			
			System.out.println("lsttransactionStatusTo:: "+lsttransactionStatusTo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lsttransactionStatusTo;
	}
	
	public TransactionStatusOrm getTransactionStatusById(int id) {
		Session session = null;
		TransactionStatusOrm transactionStatusOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			transactionStatusOrm=(TransactionStatusOrm) session.createCriteria(TransactionStatusOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return transactionStatusOrm;
	}


	
}
