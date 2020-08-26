package com.murari.comp;

public class MRFTyre implements Tyre{
	
	public MRFTyre() {
		System.out.println("MRFTyre::0-param constructor");
	}

	@Override
	public String roadGrip() {
		return "MrfTyre::Super road grip->suitable for sports";
	}
}
