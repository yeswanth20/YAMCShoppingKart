package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.DiscountTypeOrm;
import com.shopping.to.DiscountTypeTo;

public interface DiscountTypeDao {
	public DiscountTypeTo insert(DiscountTypeTo discountTypeTo);
	public DiscountTypeTo update(int id, DiscountTypeTo discountTypeTo);
	public DiscountTypeTo searchById(int id);
	public Collection<DiscountTypeTo> getAll();
	public DiscountTypeOrm getDiscountTypeById(int id);
	public boolean delete(int id);
}
