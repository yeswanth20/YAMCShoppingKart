package com.shopping.daoimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.BrandDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.BrandOrm;
import com.shopping.to.BrandTo;

public class BrandDaoimpl implements BrandDao{
	
	public BrandTo insert(BrandTo brandTo, int userId) {
		System.out.println("========================================");
		Session session = null;
		Transaction tx = null;
		try {
			System.out.println("----------------------------");
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("/////////////////////////////");
			BrandOrm brandOrm = new BrandOrm();
			brandOrm.setBrandNameEng(brandTo.getBrandNameEng());
			brandOrm.setBrandNameHindi(brandTo.getBrandNameHindi());
			brandOrm.setBrandNameTamil(brandTo.getBrandNameTamil());
			brandOrm.setBrandNameTel(brandTo.getBrandNameTel());
			brandOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			brandOrm.setCreatedDate(new Date());
			brandOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			brandOrm.setModifiedDate(new Date());
			
			tx = session.beginTransaction();
			session.save(brandOrm);
			tx.commit();
			brandTo = this.searchById(brandOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		
		return brandTo;
	}

	public BrandTo update(int id, BrandTo brandTo, int userId) {
		Session session = null;
		Transaction tx = null;
		BrandTo sendBrandTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			BrandOrm brandOrm = (BrandOrm)session.load(BrandOrm.class, new Integer(id));
			brandOrm.setBrandNameEng(brandTo.getBrandNameEng());
			brandOrm.setBrandNameHindi(brandTo.getBrandNameHindi());
			brandOrm.setBrandNameTamil(brandTo.getBrandNameTamil());
			brandOrm.setBrandNameTel(brandTo.getBrandNameTel());
			brandOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			brandOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendBrandTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			brandTo = null;
		}
		return sendBrandTo;
	}

	public BrandTo searchById(int id) {
		Session session = null;
		BrandTo brandTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			BrandOrm brandOrm=(BrandOrm) session.createCriteria(BrandOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			brandTo=new BrandTo();
			brandTo.setId(brandOrm.getId());
			brandTo.setBrandNameEng(brandOrm.getBrandNameEng());
			brandTo.setBrandNameHindi(brandOrm.getBrandNameHindi());
			brandTo.setBrandNameTamil(brandOrm.getBrandNameTamil());
			brandTo.setBrandNameTel(brandOrm.getBrandNameTel());

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return brandTo;
	}

	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		BrandOrm brandOrm = this.getBrandById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(brandOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			brandOrm = null;
		}
		
		return result;
	}

	public Collection<BrandTo> getAll() {
		Session session = null;
		ArrayList<BrandTo> lstbrandTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<BrandOrm> lstbrandOrm = (ArrayList<BrandOrm>) session.createCriteria(BrandOrm.class).list();
			BrandTo brandTo=null;
			lstbrandTo = new ArrayList<BrandTo>();
			for (BrandOrm brandOrm : lstbrandOrm) {
				//Set the Data to the To Object
				brandTo=new BrandTo();
				brandTo.setId(brandOrm.getId());
				brandTo.setBrandNameEng(brandOrm.getBrandNameEng());
				brandTo.setBrandNameHindi(brandOrm.getBrandNameHindi());
				brandTo.setBrandNameTamil(brandOrm.getBrandNameTamil());
				brandTo.setBrandNameTel(brandOrm.getBrandNameTel());
				//Add the Object to the Array List
				lstbrandTo.add(brandTo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstbrandTo;
	}
	
	public BrandOrm getBrandById(int id) {
		Session session = null;
		BrandOrm brandOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			brandOrm = (BrandOrm) session.createCriteria(BrandOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return brandOrm;
	}

	@SuppressWarnings("unchecked")
	public Collection<BrandTo> searchByName(String brnadName,int pageNumber,int pageSize) {
		brnadName=brnadName+"%";
		Session session = null;
		ArrayList<BrandOrm> brandOrm =null;
		Collection<BrandTo> brandOrmsto=new ArrayList<BrandTo>();
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Get the record based on ID From DB
			Criteria  criteria=session.createCriteria(BrandOrm.class);
			criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);
			criteria.add(Restrictions.like("brandNameEng", brnadName));
			brandOrm =  (ArrayList<BrandOrm>)criteria.list();
			for(BrandOrm brandormlist:brandOrm){
				BrandTo brandTo=new BrandTo();
				brandTo.setBrandNameEng(brandormlist.getBrandNameEng());
				brandTo.setBrandNameHindi(brandormlist.getBrandNameHindi());
				brandTo.setBrandNameTamil(brandormlist.getBrandNameTamil());
				brandTo.setBrandNameTel(brandormlist.getBrandNameTel());
				brandOrmsto.add(brandTo);
				brandTo=null;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return brandOrmsto;
	}
}
