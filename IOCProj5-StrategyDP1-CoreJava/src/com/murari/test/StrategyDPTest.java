package com.murari.test;

import com.murari.comp.Flipkart;
import com.murari.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		Flipkart fpkt=null;
		fpkt=FlipkartFactory.getInstance("firstflight");
		System.out.println(fpkt.shopping(new String[] {"rain coat","umbrella","tablets"}, new float[] {5000,2000,1000}));
	}
}
