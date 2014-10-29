package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.UserOrm;
import com.shopping.to.UsersTo;

public interface UserDao {
	public UsersTo insert(UsersTo usersTo, int userId);
	public UsersTo update(int id, UsersTo usersTo, int userId);
	public UsersTo searchById(int id);
	public Collection<UsersTo> getAll();
	public UserOrm getUserById(int id);
	public boolean delete(int id);
	public int verifyLogin(String userName, String password);
	
	

}
