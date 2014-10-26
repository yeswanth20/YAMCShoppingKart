package com.demo.hibernate;

import com.shopping.daoimpl.BrandDaoimpl;
import com.shopping.to.BrandTo;

public class Brands {
	
	public static void main(String[] args) {
		BrandTo brandTo = new BrandTo();
		brandTo.setBrandNameEng("brandNameEng");
		BrandDaoimpl brandDaoimpl = new BrandDaoimpl();
//		brandDaoimpl.insert(brandTo, 1);
//		brandDaoimpl.getAll();
		brandDaoimpl.delete(20);
		
	}

}


