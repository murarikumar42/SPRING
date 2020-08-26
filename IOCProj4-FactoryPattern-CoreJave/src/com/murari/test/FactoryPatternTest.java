package com.murari.test;

import com.murari.comp.Car;
import com.murari.factory.CarFactory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		
		Car car=null;
		car=CarFactory.getInstance("luxury");
		car.drive();
		System.out.println("..............................");
		car=CarFactory.getInstance("sports");
		car.drive();
		
		
	}
}
