package com.murari.comp;

public class ApolloTyre implements Tyre {
	public ApolloTyre() {
		System.out.println("ApolloTyre::0-param constructor");
	}
	@Override
	public String roadGrip() {
		return "ApolloTyre::standart road grip->suitable for transportation";
	}

}
