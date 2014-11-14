package com.shopping.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.TransactionOrderDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.TransactionOrderAddressOrm;
import com.shopping.orm.TransactionOrderOrm;
import com.shopping.orm.TransactionOrderProductListOrm;
import com.shopping.to.TransactionOrderAddressTo;
import com.shopping.to.TransactionOrderProductListTo;
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
			transactionOrderOrm.setTransactionStatus(ShoppingCartFactory.getTransactionStatusDao().getTransactionStatusById(transactionOrderTo.getTransactionStatus()));
			transactionOrderOrm.setTotalPrice(transactionOrderTo.getTotalPrice());
			transactionOrderOrm.setDiscountType(ShoppingCartFactory.getDiscountTypeDao().getDiscountTypeById(transactionOrderTo.getDiscountType()));
			transactionOrderOrm.setDiscountValue(transactionOrderTo.getDiscountValue());
			transactionOrderOrm.setPriceAfterDiscount(transactionOrderTo.getPriceAfterDiscount());
			
			transactionOrderOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			transactionOrderOrm.setCreatedDate(new Date());
			transactionOrderOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			transactionOrderOrm.setModifiedDate(new Date());
			//Adding Address
			TransactionOrderAddressTo txnAddressTo = transactionOrderTo.getAddress();
			TransactionOrderAddressOrm txnOrderAddressOrm = new TransactionOrderAddressOrm();
			txnOrderAddressOrm.setName(txnAddressTo.getName());
			txnOrderAddressOrm.setHouseNumber(txnAddressTo.getHouseNumber());
			txnOrderAddressOrm.setStreet(txnAddressTo.getStreet());
			txnOrderAddressOrm.setArea(txnAddressTo.getArea());
			txnOrderAddressOrm.setLandmark(txnAddressTo.getLandmark());
			txnOrderAddressOrm.setCity(ShoppingCartFactory.getCityDao().getCityById(txnAddressTo.getCity()) );
			txnOrderAddressOrm.setPincode(txnAddressTo.getPincode());
			txnOrderAddressOrm.setMobileNumber(txnAddressTo.getMobileNumber());
			txnOrderAddressOrm.setLandlineNumber(txnAddressTo.getLandlineNumber());
			txnOrderAddressOrm.setEmailID(txnAddressTo.getEmailID());
			txnOrderAddressOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			txnOrderAddressOrm.setCreatedDate(new Date());
			txnOrderAddressOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			txnOrderAddressOrm.setModifiedDate(new Date());
			transactionOrderOrm.setAddress(txnOrderAddressOrm);
			
			TransactionOrderProductListOrm productListOrm = null;
			for (TransactionOrderProductListTo productListTo : transactionOrderTo.getProductList()){
				productListOrm = new TransactionOrderProductListOrm();
				productListOrm.setUnit(ShoppingCartFactory.getUnitsDao().getUnitById(productListTo.getUnit()));
				productListOrm.setDiscountType(ShoppingCartFactory.getDiscountTypeDao().getDiscountTypeById(productListTo.getDiscountType()));
				productListOrm.setDiscountValue(productListTo.getDiscountValue());
				productListOrm.setPrice(productListTo.getPrice());
				productListOrm.setQuantity(productListTo.getQuantity());
				productListOrm.setWeight(ShoppingCartFactory.getWeightsDao().getWeightById(productListTo.getWeight()));
				productListOrm.setProduct(ShoppingCartFactory.getProductDao().getProductById(productListTo.getProduct()));
				productListOrm.setTransactionOrder(transactionOrderOrm);
				productListOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
				productListOrm.setCreatedDate(new Date());
				productListOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
				productListOrm.setModifiedDate(new Date());
				transactionOrderOrm.getProductList().add(productListOrm);
			}
				
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.persist(transactionOrderOrm);
			tx.commit();
			//Get the Updated Object from the DB
			transactionOrderTo = null;
			transactionOrderTo = this.searchById(transactionOrderOrm.getId());
			
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
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			TransactionOrderOrm transactionOrderOrm = (TransactionOrderOrm)session.load(TransactionOrderOrm.class, new Integer(id));;
			transactionOrderOrm.setTxnOrderID(transactionOrderTo.getTxnOrderID());
			transactionOrderOrm.setTransactionStatus(ShoppingCartFactory.getTransactionStatusDao().getTransactionStatusById(transactionOrderTo.getTransactionStatus()));
			transactionOrderOrm.setTotalPrice(transactionOrderTo.getTotalPrice());
			transactionOrderOrm.setDiscountType(ShoppingCartFactory.getDiscountTypeDao().getDiscountTypeById(transactionOrderTo.getDiscountType()));
			transactionOrderOrm.setDiscountValue(transactionOrderTo.getDiscountValue());
			transactionOrderOrm.setPriceAfterDiscount(transactionOrderTo.getPriceAfterDiscount());
			
			transactionOrderOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			transactionOrderOrm.setModifiedDate(new Date());
			//Adding Address
			TransactionOrderAddressTo txnAddressTo = transactionOrderTo.getAddress();
			TransactionOrderAddressOrm txnOrderAddressOrm = new TransactionOrderAddressOrm();
			txnOrderAddressOrm.setName(txnAddressTo.getName());
			txnOrderAddressOrm.setHouseNumber(txnAddressTo.getHouseNumber());
			txnOrderAddressOrm.setStreet(txnAddressTo.getStreet());
			txnOrderAddressOrm.setArea(txnAddressTo.getArea());
			txnOrderAddressOrm.setLandmark(txnAddressTo.getLandmark());
			txnOrderAddressOrm.setCity(ShoppingCartFactory.getCityDao().getCityById(txnAddressTo.getCity()) );
			txnOrderAddressOrm.setPincode(txnAddressTo.getPincode());
			txnOrderAddressOrm.setMobileNumber(txnAddressTo.getMobileNumber());
			txnOrderAddressOrm.setLandlineNumber(txnAddressTo.getLandlineNumber());
			txnOrderAddressOrm.setEmailID(txnAddressTo.getEmailID());
			txnOrderAddressOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			txnOrderAddressOrm.setModifiedDate(new Date());
			transactionOrderOrm.setAddress(txnOrderAddressOrm);
			
			TransactionOrderProductListOrm productListOrm = null;
			for (TransactionOrderProductListTo productListTo : transactionOrderTo.getProductList()){
				productListOrm = new TransactionOrderProductListOrm();
				productListOrm.setUnit(ShoppingCartFactory.getUnitsDao().getUnitById(productListTo.getUnit()));
				productListOrm.setDiscountType(ShoppingCartFactory.getDiscountTypeDao().getDiscountTypeById(productListTo.getDiscountType()));
				productListOrm.setDiscountValue(productListTo.getDiscountValue());
				productListOrm.setPrice(productListTo.getPrice());
				productListOrm.setQuantity(productListTo.getQuantity());
				productListOrm.setWeight(ShoppingCartFactory.getWeightsDao().getWeightById(productListTo.getWeight()));
				productListOrm.setProduct(ShoppingCartFactory.getProductDao().getProductById(productListTo.getProduct()));
				productListOrm.setTransactionOrder(transactionOrderOrm);
				productListOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
				productListOrm.setModifiedDate(new Date());
				transactionOrderOrm.getProductList().add(productListOrm);
			}
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			transactionOrderTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			
		}
		return transactionOrderTo;
	}

	public TransactionOrderTo searchById(int id) {
		Session session = null;
		TransactionOrderTo txnOrderTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			TransactionOrderOrm txnOrderOrm = (TransactionOrderOrm) session.createCriteria(TransactionOrderOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			txnOrderTo = new TransactionOrderTo();
			txnOrderTo.setTxnOrderID(txnOrderOrm.getTxnOrderID());
			txnOrderTo.setTransactionStatus(txnOrderOrm.getTransactionStatus().getId());
			txnOrderTo.setTotalPrice(txnOrderOrm.getTotalPrice());
			txnOrderTo.setDiscountType(txnOrderOrm.getDiscountType().getId());
			txnOrderTo.setDiscountValue(txnOrderOrm.getDiscountValue());
			txnOrderTo.setPriceAfterDiscount(txnOrderOrm.getPriceAfterDiscount());
			
			//Adding Address
			TransactionOrderAddressTo txnAddressTo = new TransactionOrderAddressTo();
			TransactionOrderAddressOrm txnOrderAddressOrm = txnOrderOrm.getAddress();
			txnAddressTo.setName(txnOrderAddressOrm.getName());
			txnAddressTo.setHouseNumber(txnOrderAddressOrm.getHouseNumber());
			txnAddressTo.setStreet(txnOrderAddressOrm.getStreet());
			txnAddressTo.setArea(txnOrderAddressOrm.getArea());
			txnAddressTo.setLandmark(txnOrderAddressOrm.getLandmark());
			txnAddressTo.setCity(txnOrderAddressOrm.getCity().getId());
			txnAddressTo.setPincode(txnAddressTo.getPincode());
			txnAddressTo.setMobileNumber(txnAddressTo.getMobileNumber());
			txnAddressTo.setLandlineNumber(txnAddressTo.getLandlineNumber());
			txnAddressTo.setEmailID(txnAddressTo.getEmailID());
			txnOrderTo.setAddress(txnAddressTo);
			
			TransactionOrderProductListTo productListTo = null;
			for (TransactionOrderProductListOrm productListOrm : txnOrderOrm.getProductList()){
				productListTo = new TransactionOrderProductListTo();
				productListTo.setUnit(productListOrm.getUnit().getId());
				productListTo.setDiscountType(productListOrm.getDiscountType().getId());
				productListTo.setDiscountValue(productListOrm.getDiscountValue());
				productListTo.setPrice(productListOrm.getPrice());
				productListTo.setQuantity(productListOrm.getQuantity());
				productListTo.setWeight(productListOrm.getWeight().getId());
				productListTo.setProduct(productListOrm.getProduct().getId());
				productListTo.setTransactionOrder(txnOrderTo.getId());
				txnOrderTo.getProductList().add(productListTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return txnOrderTo;
	}

	
	public TransactionOrderTo searchByTxnOrderId(String txnOrderID) {
		Session session = null;
		TransactionOrderTo txnOrderTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			TransactionOrderOrm txnOrderOrm = (TransactionOrderOrm) session.createCriteria(TransactionOrderOrm.class).add(Restrictions.eq("txnOrderID", txnOrderID)).uniqueResult();
			txnOrderTo = this.searchById(txnOrderOrm.getId());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return txnOrderTo;
	}

	
	public Collection<TransactionOrderTo> getAll() {
		Session session = null;
		ArrayList<TransactionOrderTo> lstTxnOrderTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<TransactionOrderOrm> lstTxnOrderOrm = (ArrayList<TransactionOrderOrm>) session.createCriteria(TransactionOrderOrm.class).list();
			TransactionOrderTo txnOrderTo = null;
			lstTxnOrderTo = new ArrayList<TransactionOrderTo>();
			for (TransactionOrderOrm txnOrderOrm : lstTxnOrderOrm) {
				//Set the Data to the To Object
				txnOrderTo = new TransactionOrderTo();
				txnOrderTo.setTxnOrderID(txnOrderOrm.getTxnOrderID());
				txnOrderTo.setTransactionStatus(txnOrderOrm.getTransactionStatus().getId());
				txnOrderTo.setTotalPrice(txnOrderOrm.getTotalPrice());
				txnOrderTo.setDiscountType(txnOrderOrm.getDiscountType().getId());
				txnOrderTo.setDiscountValue(txnOrderOrm.getDiscountValue());
				txnOrderTo.setPriceAfterDiscount(txnOrderOrm.getPriceAfterDiscount());
				
				//Adding Address
				TransactionOrderAddressTo txnAddressTo = new TransactionOrderAddressTo();
				TransactionOrderAddressOrm txnOrderAddressOrm = txnOrderOrm.getAddress();
				txnAddressTo.setName(txnOrderAddressOrm.getName());
				txnAddressTo.setHouseNumber(txnOrderAddressOrm.getHouseNumber());
				txnAddressTo.setStreet(txnOrderAddressOrm.getStreet());
				txnAddressTo.setArea(txnOrderAddressOrm.getArea());
				txnAddressTo.setLandmark(txnOrderAddressOrm.getLandmark());
				txnAddressTo.setCity(txnOrderAddressOrm.getCity().getId());
				txnAddressTo.setPincode(txnAddressTo.getPincode());
				txnAddressTo.setMobileNumber(txnAddressTo.getMobileNumber());
				txnAddressTo.setLandlineNumber(txnAddressTo.getLandlineNumber());
				txnAddressTo.setEmailID(txnAddressTo.getEmailID());
				txnOrderTo.setAddress(txnAddressTo);
				
				TransactionOrderProductListTo productListTo = null;
				for (TransactionOrderProductListOrm productListOrm : txnOrderOrm.getProductList()){
					productListTo = new TransactionOrderProductListTo();
					productListTo.setUnit(productListOrm.getUnit().getId());
					productListTo.setDiscountType(productListOrm.getDiscountType().getId());
					productListTo.setDiscountValue(productListOrm.getDiscountValue());
					productListTo.setPrice(productListOrm.getPrice());
					productListTo.setQuantity(productListOrm.getQuantity());
					productListTo.setWeight(productListOrm.getWeight().getId());
					productListTo.setProduct(productListOrm.getProduct().getId());
					productListTo.setTransactionOrder(txnOrderTo.getId());
					txnOrderTo.getProductList().add(productListTo);
				}

				//Add the Object to the Array List
				lstTxnOrderTo.add(txnOrderTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstTxnOrderTo;
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
