package com.shopping.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.shopping.orm.WeightsOrm;
import com.shopping.to.WeightsTo;

public interface WeightsDao {
	public WeightsTo insert(WeightsTo weightsTo, int userId);
	public WeightsTo update(int id, WeightsTo weightsTo, int userId);
	public WeightsTo searchById(int id);
	public Collection<WeightsTo> searchByUnitId(int unitId);
	public Collection<WeightsTo> getAll();
	public WeightsOrm getWeightById(int id);
	public ArrayList<WeightsTo> searchByUnitName(String weightName,int pageNumber,int pageSize);
	public boolean delete(int id);
}
