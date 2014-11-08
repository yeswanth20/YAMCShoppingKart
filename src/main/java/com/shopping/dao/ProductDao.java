package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.ProductOrm;
import com.shopping.to.ProductTo;

public interface ProductDao {
	public ProductTo insert(ProductTo productTo, int userId);
	public ProductTo update(int id, ProductTo productTo, int userId);
	public ProductTo searchById(int id);
	public Collection<ProductTo> getAll(int pageNumber,int pageSize);
	public ProductOrm getProductById(int id);
	
	public boolean delete(int id);
}
