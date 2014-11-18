package com.demo.hibernate;

import java.util.ArrayList;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.CategoriesTo;

public class categories {
	
	public static void main(String[] args) {
		System.out.println("hiiiiiiiiiiiii");
		CategoriesTo categoriesTo = new CategoriesTo();
		categoriesTo.setCategoryNameEng("Aliiiiiiiiii");
		
		ShoppingCartFactory.getCategoriesDao().insert(categoriesTo, 1);
//		ArrayList<CategoriesTo> lstTos = (ArrayList<CategoriesTo>) ShoppingCartFactory.getCategoriesDao().getAll();
//		for (CategoriesTo to :lstTos){
//			System.out.println("-----eng:"+to.getCategoryNameEng());
//		}
	}

}


