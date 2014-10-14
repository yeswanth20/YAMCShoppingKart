package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.UnitsOrm;
import com.shopping.to.UnitsTo;

public interface UnitsDao {
	public UnitsTo insert(UnitsTo unitTo,int userId);
	public UnitsTo update(int id, UnitsTo unitsTo,int userId);
	public UnitsTo searchById(int id);
	public Collection<UnitsTo> getAll();
	public UnitsOrm getUnitById(int id);
	public boolean delete(int id);
}
