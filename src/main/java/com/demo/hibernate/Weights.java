package com.demo.hibernate;

import java.util.ArrayList;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.WeightsTo;

public class Weights {
	
	public static void main(String[] args) {

		WeightsTo weightsTo = new WeightsTo();
		weightsTo.setWeightName("Aliiiiiiiiii");
		weightsTo.setWeightValue(10.5);
	
//		UnitsOrm u = (UnitsOrm)session.get(UnitsOrm.class, 1);
//		weightsTo.setUnit(u);
//		UnitsTo to = ShoppingCartFactory.getUnitsDao().searchById(1);
		weightsTo.setUnit(10);
//		ShoppingCartFactory.getWeightsDao().insert(weightsTo, 1);
		ArrayList<WeightsTo> lstTo1 = (ArrayList<WeightsTo>) ShoppingCartFactory.getWeightsDao().searchByUnitId(10);
		for (WeightsTo weightsTo2 : lstTo1) {
			System.out.println("unit"+weightsTo2.getUnit());
			System.out.println("weight"+weightsTo2.getWeightName());
		}
	}
}


