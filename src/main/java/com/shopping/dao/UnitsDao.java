package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.UnitsOrm;
import com.shopping.to.UnitsTo;

public interface UnitsDao {
	public UnitsTo insert(UnitsTo unitTo);
	public UnitsTo update(int id, UnitsTo unitsTo);
	public UnitsTo searchById(int id);
	public Collection<UnitsTo> getAll();
	public UnitsOrm getUnitById(int id);
	public boolean delete(int id);
}
