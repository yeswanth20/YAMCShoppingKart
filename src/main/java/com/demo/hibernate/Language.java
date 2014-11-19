package com.demo.hibernate;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.LanguageTo;

public class Language {
	
	public static void main(String[] args) {
		LanguageTo languageTo = new LanguageTo();
		languageTo.setLanguageName("Status 4");

		ShoppingCartFactory.getLanguageDao().insert(languageTo, 2);
//		ShoppingCartFactory.getLanguageDao().delete(210);
		
	}

}


