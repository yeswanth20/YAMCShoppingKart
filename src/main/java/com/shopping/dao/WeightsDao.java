package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.WeightsOrm;
import com.shopping.to.WeightsTo;

public interface WeightsDao {
	public WeightsTo insert(WeightsTo weightsTo, int userId);
	public WeightsTo update(int id, WeightsTo weightsTo, int userId);
	public WeightsTo searchById(int id);
	public Collection<WeightsTo> getAll();
	public WeightsOrm getWeightById(int id);
	public boolean delete(int id);
}
