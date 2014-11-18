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
			weightsOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			weightsOrm.setCreatedDate(new Date());
			weightsOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			weightsOrm.setModifiedDate(new Date());
			
			
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(weightsOrm);
			tx.commit();
			//Get the Updated Object from the DB
			weightsTo = this.searchById(weightsOrm.getId());
			sendWeightsTo = weightsTo;
			
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
			weightsOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
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
			weightsTo = setWeightOrm2To(weightsOrm);

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return weightsTo;
	}

	
	public Collection<WeightsTo> searchByUnitId(int unitId) {
		System.out.println("I am in searchByUnitId"); 
		Session session = null;
		WeightsTo weightsTo = null;
		ArrayList<WeightsTo> lstWeightsTo = new ArrayList<WeightsTo>();
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			
			@SuppressWarnings("unchecked")
			ArrayList<WeightsOrm> lstWeightsOrm = (ArrayList<WeightsOrm>) session.createCriteria(WeightsOrm.class).add(Restrictions.eq("unit.id", unitId)).list();
			System.out.println("lst size"+lstWeightsOrm.size());
			

			//Set the Data to the To Object
			for(WeightsOrm weightsOrm: lstWeightsOrm){
				weightsTo = this.setWeightOrm2To(weightsOrm);
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
	
	
	public WeightsTo setWeightOrm2To(WeightsOrm weightsOrm){
		
		WeightsTo weightsTo = new WeightsTo();
		weightsTo.setId(weightsOrm.getId());
		weightsTo.setWeightName(weightsOrm.getWeightName());
		weightsTo.setUnit(weightsOrm.getUnit().getId());
		return weightsTo;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		WeightsOrm weightsOrm = this.getWeightById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(weightsOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			weightsOrm = null;
		}
		
		return result;
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
				weightsTo = this.setWeightOrm2To(weightsOrm);

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
