package com.shopping.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.RoleDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.RoleOrm;
import com.shopping.to.RoleTo;

public class RoleDaoimpl implements RoleDao {

	public RoleTo insert(RoleTo roleTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			RoleOrm roleOrm = new RoleOrm();
			roleOrm.setRoleName(roleTo.getRoleName());
			roleOrm.setCreatedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			roleOrm.setCreatedDate(new Date());
			roleOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			roleOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(roleOrm);
			tx.commit();
			//Get the Updated Object from the DB
			roleTo=null;
			roleTo = this.searchById(roleOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return roleTo;
	}

	public RoleTo update(int id, RoleTo roleTo, int userId) {
		Session session = null;
		Transaction tx = null;
		RoleTo sendRoleTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Update the ORM
			RoleOrm roleOrm = (RoleOrm)session.load(RoleOrm.class, new Integer(id));
			roleOrm.setRoleName(roleTo.getRoleName());
			roleOrm.setModifiedBy(ShoppingCartFactory.getUserDao().getUserById(userId));
			roleOrm.setModifiedDate(new Date());
			
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendRoleTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			roleTo = null;
		}
		return sendRoleTo;
	}

	public boolean delete(int id) {
		boolean result = true;
		//Get Object
		RoleOrm roleOrm = this.getRoleById(id);
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction & save the object
			tx = session.beginTransaction();
			//Delete the Object
			session.delete(roleOrm);
			tx.commit();
			
		} catch (Exception e) {
			result = false;
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx = null;
			roleOrm = null;
		}
		
		return result;
	}

	public Collection<RoleTo> getAll() {
		Session session = null;
		ArrayList<RoleTo> lstroleTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<RoleOrm> lstRoleOrm = (ArrayList<RoleOrm>) session.createCriteria(RoleOrm.class).list();
			RoleTo roleTo = null;
			lstroleTo = new ArrayList<RoleTo>();
			for (RoleOrm roleOrm : lstRoleOrm) {
				//Set the Data to the To Object
				roleTo = new RoleTo();
				roleTo.setId(roleOrm.getId());
				roleTo.setRoleName(roleOrm.getRoleName());
				//Add the Object to the Array List
				lstroleTo.add(roleTo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstroleTo;
	}

	public RoleTo searchById(int id) {
		Session session = null;
		RoleTo roleTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			RoleOrm roleOrm = (RoleOrm) session.createCriteria(RoleOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			roleTo = new RoleTo();
			roleTo.setId(roleOrm.getId());
			roleTo.setRoleName(roleOrm.getRoleName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return roleTo;
	}
	
	public RoleOrm getRoleById(int id) {
		Session session = null;
		RoleOrm roleOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			roleOrm = (RoleOrm) session.createCriteria(RoleOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return roleOrm;
	}
	
}
