package com.shopping.daoimpl;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.TransactionOrderDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.TransactionOrderAddressOrm;
import com.shopping.orm.TransactionOrderOrm;
import com.shopping.to.TransactionOrderAddressTo;
import com.shopping.to.TransactionOrderTo;

public class TransactionOrderDaoimpl implements TransactionOrderDao{

	public TransactionOrderTo insert(TransactionOrderTo transactionOrderTo,
			int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			TransactionOrderOrm transactionOrderOrm = new TransactionOrderOrm();
			transactionOrderOrm.setTxnOrderID(transactionOrderTo.getTxnOrderID());
//			transactionOrderOrm.setTransactionStatus();
			transactionOrderOrm.setTotalPrice(transactionOrderTo.getTotalPrice());
//			transactionOrderOrm.setDiscountType(new );
			transactionOrderOrm.setDiscountValue(transactionOrderTo.getDiscountValue());
			transactionOrderOrm.setPriceAfterDiscount(transactionOrderTo.getPriceAfterDiscount());
			
			transactionOrderOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			transactionOrderOrm.setCreatedDate(new Date());
			transactionOrderOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			transactionOrderOrm.setModifiedDate(new Date());
			//Adding Address
			/*TransactionOrderAddressTo txnAddressTo = transactionOrderTo.getAddress();
			TransactionOrderAddressOrm txnOrderAddressOrm = new TransactionOrderAddressOrm();
			txnOrderAddressOrm.setName(txnAddressTo.getName());
			txnOrderAddressOrm.setHouseNumber(txnAddressTo.getHouseNumber());
			txnOrderAddressOrm.setStreet(txnAddressTo.getStreet());
			txnOrderAddressOrm.setArea(txnAddressTo.getArea());
			txnOrderAddressOrm.setLandmark(txnAddressTo.getLandmark());
//			txnOrderAddressOrm.setCity(new );
			txnOrderAddressOrm.setPincode(txnAddressTo.getPincode());
			txnOrderAddressOrm.setMobileNumber(txnAddressTo.getMobileNumber());
			txnOrderAddressOrm.setLandlineNumber(txnAddressTo.getLandlineNumber());
			txnOrderAddressOrm.setEmailID(txnAddressTo.getEmailID());
//			txnOrderAddressOrm.setTransactionOrder(this.getTransactionOrderById(txnAddressTo.getTransactionOrder()));
			*/
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(transactionOrderOrm);
			tx.commit();
			//Get the Updated Object from the DB
//			transactionOrderTo = null;
//			transactionOrderTo = this.searchById(transactionOrderOrm.getId());
			
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			
		}
		return null;
	}

	public TransactionOrderTo update(int id,
			TransactionOrderTo transactionOrderTo, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public TransactionOrderTo searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<TransactionOrderTo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public TransactionOrderOrm getTransactionOrderById(int id) {
		Session session = null;
		TransactionOrderOrm transactionOrderOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			transactionOrderOrm = (TransactionOrderOrm) session.createCriteria(TransactionOrderOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return transactionOrderOrm;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
