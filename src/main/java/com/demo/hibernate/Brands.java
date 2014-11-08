package com.demo.hibernate;

import com.shopping.daoimpl.BrandDaoimpl;
import com.shopping.to.BrandTo;

public class Brands {
	
	public static void main(String[] args) {
		BrandTo brandTo = new BrandTo();
		brandTo.setBrandNameEng("BRAND 2");
		BrandDaoimpl brandDaoimpl = new BrandDaoimpl();
		brandDaoimpl.insert(brandTo,1);
//		brandDaoimpl.getAll();
		
	}

}


