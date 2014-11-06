package com.shopping.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.UserDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.UserOrm;
import com.shopping.to.UsersTo;

public class UserDaoimpl implements UserDao{
	public UserOrm getUserById(int id) {
		Session session = null;
		UserOrm userOrm =null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			userOrm=(UserOrm) session.createCriteria(UserOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return userOrm;
	}


	public UsersTo insert(UsersTo usersTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			UserOrm userOrm = new UserOrm();
			userOrm.setUserName(usersTo.getUserName());
			userOrm.setPassword(usersTo.getPassword());
			userOrm.setCreatedBy(new UserDaoimpl().getUserById(userId));
			userOrm.setCreatedDate(new Date());
			userOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			userOrm.setModifiedDate(new Date());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(userOrm);
			tx.commit();
			//Get the Updated Object from the DB
			usersTo=null;
			usersTo = this.searchById(userOrm.getId());

		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		System.out.println(usersTo.getId());
		return usersTo;
	}

	public UsersTo update(int id, UsersTo usersTo, int userId) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			//Update the ORM
			UserOrm userOrm = (UserOrm) session.load(UserOrm.class, new Integer(id));
			userOrm.setUserName(usersTo.getUserName());
			userOrm.setPassword(usersTo.getPassword());
			userOrm.setModifiedBy(new UserDaoimpl().getUserById(userId));
			userOrm.setModifiedDate(new Date());

			//Commit the Transaction
			tx.commit();

			//Get the Updated Object from the DB
			usersTo = null;
			usersTo = this.searchById(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return usersTo;
	}

	public UsersTo searchById(int id) {
		Session session = null;
		UsersTo usersTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			UserOrm usersOrm=(UserOrm) session.createCriteria(UserOrm.class).add(Restrictions.eq("id", id)).uniqueResult();

			//Set the Data to the To Object
			usersTo=new UsersTo();
			usersTo.setId(usersOrm.getId());
			usersTo.setUserName(usersOrm.getUserName());
			usersTo.setPassword(usersOrm.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return usersTo;
	}

	public Collection<UsersTo> getAll() {
		Session session = null;
		ArrayList<UsersTo> lstUsersTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<UserOrm> lstUsersOrm = (ArrayList<UserOrm>) session.createCriteria(UserOrm.class).list();
			UsersTo usersTo = null;
			lstUsersTo = new ArrayList<UsersTo>();
			for (UserOrm usersOrm : lstUsersOrm) {
				//Set the Data to the To Object
				usersTo=new UsersTo();
				usersTo.setId(usersOrm.getId());
				usersTo.setUserName(usersOrm.getUserName());
				usersTo.setPassword(usersOrm.getPassword());
				//Add the Object to the Array List
				lstUsersTo.add(usersTo);
			}


		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstUsersTo;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@SuppressWarnings("rawtypes")
	public int verifyLogin(String userName, String password) {
		Session session = null;
		@SuppressWarnings("unused")
		ArrayList<UsersTo> lstUsersTo = null;
		int userId = 0;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();

			//Get the record based on ID From DB
			Criteria criteria=session.createCriteria(UserOrm.class);
			Criterion usrName = Restrictions.ilike("userName", userName, MatchMode.EXACT);
			Criterion pwd = Restrictions.ilike("password", password, MatchMode.EXACT);
			LogicalExpression logicalExpression = Restrictions.and(usrName, pwd);
			criteria.add(logicalExpression);
			ProjectionList projectionList=Projections.projectionList();
			projectionList.add(Projections.property("id"));
			criteria.setProjection(projectionList);
			List list=criteria.list();
			Iterator iterator=list.iterator();
			
			while(iterator.hasNext()){
				Object logindetails = iterator.next();
				userId = Integer.parseInt(logindetails.toString());



			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return userId;
	}

}
