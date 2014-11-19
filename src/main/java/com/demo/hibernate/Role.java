package com.demo.hibernate;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.RoleTo;

public class Role {
	
	public static void main(String[] args) {
		RoleTo roleTo = new RoleTo();
		roleTo.setRoleName("Status 4");

		ShoppingCartFactory.getRoleDao().insert(roleTo, 2);
//		ShoppingCartFactory.getRoleDao().delete(210);
		
	}

}


