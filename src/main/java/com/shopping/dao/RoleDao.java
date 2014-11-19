package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.RoleOrm;
import com.shopping.to.RoleTo;

public interface RoleDao {
	public RoleTo insert(RoleTo roleTo, int userId);
	public RoleTo update(int id, RoleTo roleTo, int userId);
	public RoleTo searchById(int id);
	public Collection<RoleTo> getAll();
	public RoleOrm getRoleById(int id);
	public boolean delete(int id);

}
