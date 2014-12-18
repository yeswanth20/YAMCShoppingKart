package com.shopping.hibernate.service;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.TransactionOrderOrm;

public class TransactionNumberGeneration {

	public  String getCurrentYearDayTime(Integer userid){
		Calendar date;
		date = Calendar.getInstance();
		Integer CurrentDayOfYear=date.get(Calendar.DAY_OF_YEAR);
		Integer year=date.get(Calendar.YEAR);
		Integer hour=date.get(Calendar.HOUR);
		Integer minute=date.get(Calendar.MINUTE);
		Integer second=date.get(Calendar.SECOND);
		if(userid.toString().length()!=4){
			int repeatedNumberOfTimes=4-userid.toString().length();
			String repeateCharacter="0";
			return year.toString().substring(2,4)+CurrentDayOfYear.toString()+hour.toString()+minute.toString()+second.toString()+userid.toString()+StringUtils.repeat(repeateCharacter, repeatedNumberOfTimes);
		}
		return year.toString().substring(2,4)+CurrentDayOfYear.toString()+hour.toString()+minute.toString()+second.toString()+userid.toString();
	}


	public String getPerviousnumber(Integer userid){
		DetachedCriteria maxidoftheinvoicenumber = DetachedCriteria.forClass(TransactionOrderOrm.class)
				.setProjection( Property.forName("id").max());
//				.add(Restrictions.like("txnOrderID", this.getCurrentYearDayTime(userid),MatchMode.START));

		Session session =  HibernateUtil.getSessionFactory().openSession();

		try{
			String previousInvoiceNumber=session.createCriteria(TransactionOrderOrm.class)
					.add( Property.forName("id").eq(maxidoftheinvoicenumber) )
					.setProjection(Projections.property("txnOrderID"))
					.uniqueResult().toString();
			Integer generatedNumber=Integer.parseInt(previousInvoiceNumber.substring(14, previousInvoiceNumber.length()))+1;
			
			return this.getCurrentYearDayTime(userid)+generatedNumber.toString();
			
		}catch(Exception exception){
			return this.getCurrentYearDayTime(userid)+"1";
		}
	}
}
