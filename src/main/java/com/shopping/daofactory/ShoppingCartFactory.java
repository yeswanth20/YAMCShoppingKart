package com.shopping.daofactory;

import com.shopping.dao.BrandDao;
import com.shopping.dao.CategoriesDao;
import com.shopping.dao.DiscountTypeDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.UnitsDao;
import com.shopping.dao.UserDao;
import com.shopping.dao.WeightsDao;
import com.shopping.daoimpl.BrandDaoimpl;
import com.shopping.daoimpl.CategoriesDaoimpl;
import com.shopping.daoimpl.DiscountTypeDaoimpl;
import com.shopping.daoimpl.ProductDaoimpl;
import com.shopping.daoimpl.UnitDaoimpl;
import com.shopping.daoimpl.UserDaoimpl;
import com.shopping.daoimpl.WeightsDaoimpl;

public class ShoppingCartFactory {

	public static UserDao userDao;
	public static BrandDao brandDao;
	public static CategoriesDao categoriesDao;
	public static DiscountTypeDao discountTypeDao;
	public static ProductDao productDao;
	public static UnitsDao unitsDao;
	public static WeightsDao weightsDao;
	static{
		userDao = new UserDaoimpl();
		brandDao = new BrandDaoimpl();
		categoriesDao = new CategoriesDaoimpl();
		discountTypeDao = new DiscountTypeDaoimpl();
		productDao = new ProductDaoimpl();
		unitsDao = new UnitDaoimpl();
		weightsDao = new WeightsDaoimpl();
	}

	
	//Getters & Setters
	public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		ShoppingCartFactory.userDao = userDao;
	}
	
	public static BrandDao getBrandDao() {
		return brandDao;
	}

	public static void setBrandDao(BrandDao brandDao) {
		ShoppingCartFactory.brandDao = brandDao;
	}

	public static CategoriesDao getCategoriesDao() {
		return categoriesDao;
	}

	public static void setCategoriesDao(CategoriesDao categoriesDao) {
		ShoppingCartFactory.categoriesDao = categoriesDao;
	}

	public static DiscountTypeDao getDiscountTypeDao() {
		return discountTypeDao;
	}

	public static void setDiscountTypeDao(DiscountTypeDao discountTypeDao) {
		ShoppingCartFactory.discountTypeDao = discountTypeDao;
	}

	public static ProductDao getProductDao() {
		return productDao;
	}

	public static void setProductDao(ProductDao productDao) {
		ShoppingCartFactory.productDao = productDao;
	}

	public static WeightsDao getWeightsDao() {
		return weightsDao;
	}

	public static void setWeightsDao(WeightsDao weightsDao) {
		ShoppingCartFactory.weightsDao = weightsDao;
	}

	public static UnitsDao getUnitsDao() {
		return unitsDao;
	}

	public static void setUnitsDao(UnitsDao unitsDao) {
		ShoppingCartFactory.unitsDao = unitsDao;
	}
	
	
}
