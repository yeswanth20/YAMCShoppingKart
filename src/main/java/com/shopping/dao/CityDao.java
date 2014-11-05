package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.BrandOrm;
import com.shopping.to.CityTo;

public interface CityDao {
	public CityTo insert(CityTo cityTo, int userId);
	public CityTo update(int id, CityTo cityTo, int userId);
	public CityTo searchById(int id);
	public Collection<CityTo> getAll();
	public BrandOrm getBrandById(int id);
	public boolean delete(int id);

}
