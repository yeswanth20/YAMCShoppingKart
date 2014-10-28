package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.WeightsDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.WeightsOrm;
import com.shopping.to.WeightsTo;

public class WeightsDaoimpl implements WeightsDao{
	public WeightsTo insert(WeightsTo weightsTo,int userId) {
		Session session = null;
		Transaction tx = null;
		WeightsTo sendWeightsTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Set the ORM
			WeightsOrm weightsOrm = new WeightsOrm();
			weightsOrm.setId(weightsTo.getId());
			weightsOrm.setWeightName(weightsTo.getWeightName());
			weightsOrm.setUnit(new UnitDaoimpl().getUnitById(weightsTo.getUnit()));
			weightsOrm.setCreatedBy(new UserDaoimpl().getUserById(weightsTo.getCreatedBy()));
			weightsOrm.setCreatedDate(new Date());
			weightsOrm.setModifiedBy(new UserDaoimpl().getUserById(weightsTo.getModifiedBy()));
			weightsOrm.setModifiedDate(new Date());
			
			
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(weightsOrm);
			tx.commit();
			//Get the Updated Object from the DB
			weightsTo = this.searchById(weightsOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return sendWeightsTo;
	}

	public WeightsTo update(int id, WeightsTo weightsTo,int userId) {
		Session session = null;
		Transaction tx = null;
		WeightsTo  sendWeightsTo= null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			//Update the ORM
			WeightsOrm  weightsOrm = (WeightsOrm)session.load(WeightsOrm.class, new Integer(id));

			weightsOrm.setWeightName(weightsTo.getWeightName());
			weightsOrm.setUnit(new UnitDaoimpl().getUnitById(weightsTo.getUnit()));
			weightsOrm.setModifiedBy(new UserDaoimpl().getUserById(weightsTo.getModifiedBy()));
			weightsOrm.setModifiedDate(new Date());


			//Commit the Transaction
			tx.commit();

			//Get the Updated Object from the DB
			sendWeightsTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			weightsTo = null;
		}
		return sendWeightsTo;
	}

	public WeightsTo searchById(int id) {
		Session session = null;
		WeightsTo weightsTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			WeightsOrm weightsOrm = (WeightsOrm) session.createCriteria(WeightsOrm.class).add(Restrictions.eq("id", id)).uniqueResult();

			//Set the Data to the To Object
			weightsTo=new WeightsTo();
			weightsTo.setId(weightsOrm.getId());
			weightsTo.setWeightName(weightsOrm.getWeightName());
			weightsTo.setUnit(weightsOrm.getUnit().getId());
			
			//		discountTypeTo.setStatusMsg(discountTypeOrm.gets);

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return weightsTo;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<WeightsTo> getAll() {
		Session session = null;
		ArrayList<WeightsTo>  lstWeightsTo= null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<WeightsOrm> lstWeightsOrm = (ArrayList<WeightsOrm>) session.createCriteria(WeightsOrm.class).list();
			WeightsTo weightsTo = null;
			lstWeightsTo = new ArrayList<WeightsTo>();
			for (WeightsOrm weightsOrm : lstWeightsOrm) {
				//Set the Data to the To Object

				weightsTo=new WeightsTo();
				weightsTo.setId(weightsOrm.getId());
				weightsTo.setWeightName(weightsOrm.getWeightName());
				weightsTo.setUnit(weightsOrm.getUnit().getId());

				//Add the Object to the Array List
				lstWeightsTo.add(weightsTo);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstWeightsTo;
	}

	public WeightsOrm getWeightById(int id) {
		Session session = null;
		WeightsOrm weightsOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			weightsOrm = (WeightsOrm) session.createCriteria(WeightsOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return weightsOrm;
	}

}
