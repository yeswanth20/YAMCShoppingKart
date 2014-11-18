package com.demo.hibernate;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.daoimpl.CityDaoimpl;
import com.shopping.to.CityTo;

public class City {
	
	public static void main(String[] args) {
		CityTo cityTo = new CityTo();
		cityTo.setCityName("Status 4");
//		CityDaoimpl cityDaoimpl = new CityDaoimpl();
//		cityDaoimpl.insert(cityTo,1);
//		cityDaoimpl.getAll();
//		System.out.println("");
//		ShoppingCartFactory.getCityDao().insert(cityTo, 2);
		ShoppingCartFactory.getCityDao().delete(210);
		
	}

}


