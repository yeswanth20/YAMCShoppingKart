package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.LanguageOrm;
import com.shopping.to.LanguageTo;

public interface LanguageDao {
	public LanguageTo insert(LanguageTo languageTo, int userId);
	public LanguageTo update(int id, LanguageTo languageTo, int userId);
	public LanguageTo searchById(int id);
	public Collection<LanguageTo> getAll();
	public LanguageOrm getLanguageById(int id);
	public boolean delete(int id);

}
