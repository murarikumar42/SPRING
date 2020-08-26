package com.murari.factory;

import com.murari.comp.ApolloTyre;
import com.murari.comp.BudgetCar;
import com.murari.comp.CETATyre;
import com.murari.comp.Car;
import com.murari.comp.LuxuryCar;
import com.murari.comp.MRFTyre;
import com.murari.comp.SportsCar;
import com.murari.comp.Tyre;

public class CarFactory {

	//factory method
	public static Car getInstance(String type) {
		
		Tyre tyre=null;
		Car car=null;
		
		if(type.equalsIgnoreCase("luxury")) {
			tyre=new CETATyre();
			car=new LuxuryCar(tyre);
		}
		else if(type.equalsIgnoreCase("sports")) {
			tyre=new MRFTyre();
			car=new SportsCar(tyre);
		}
		else if(type.equalsIgnoreCase("budget")) {
			tyre=new ApolloTyre();
			car=new BudgetCar(tyre);
		}
		else
			throw new IllegalArgumentException("Invalid Car Type");
		
		return car;
	}
}
