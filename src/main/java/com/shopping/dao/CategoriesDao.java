package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.CategoriesOrm;
import com.shopping.to.CategoriesTo;

public interface CategoriesDao {
	public CategoriesTo insert(CategoriesTo categoriesTo, int userId);
	public CategoriesTo update(int id, CategoriesTo categoriesTo, int userId);
	public CategoriesTo searchById(int id);
	public Collection<CategoriesTo> getAll();
	public CategoriesOrm getCategoryById(int id);
	public boolean delete(int id);
}
