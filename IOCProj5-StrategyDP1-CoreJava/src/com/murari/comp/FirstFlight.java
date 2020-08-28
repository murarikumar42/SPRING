package com.murari.comp;

public final class FirstFlight implements Courier {

	public FirstFlight() {
		System.out.println("FirstFlight. 0 param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return "FirstFlight courier will deliver order id::" +oid+" order products";
	}

}
