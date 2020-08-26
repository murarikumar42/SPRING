package com.murari.comp;

public class CETATyre implements Tyre{
	
	public CETATyre() {
		System.out.println("CETATyre:0Parma constructor");
	}

	@Override
	public String roadGrip() {
		return "CEATTyre::smooth road grip->suitable for luxury";
	}
}
