package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.BrandOrm;
import com.shopping.to.BrandTo;

public interface BrandDao {
	public BrandTo insert(BrandTo brandTo, int userId);
	public BrandTo update(int id, BrandTo brandTo, int userId);
	public BrandTo searchById(int id);
	public Collection<BrandTo> getAll();
	public BrandOrm getBrandById(int id);
	public boolean delete(int id);

}
