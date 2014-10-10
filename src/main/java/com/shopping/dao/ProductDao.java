package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.ProductOrm;
import com.shopping.to.ProductTo;

public interface ProductDao {
	public ProductTo insert(ProductTo productTo);
	public ProductTo update(int id, ProductTo productTo);
	public ProductTo searchById(int id);
	public Collection<ProductTo> getAll();
	public ProductOrm getProductById(int id);
	
	public boolean delete(int id);
}
