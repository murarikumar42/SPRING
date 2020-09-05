package com.murari.beans;

import java.util.Date;

public class WishMessageGenerator {

	//bean property
	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}
	public String generateWishMessage(String user) {
		int hour=0;
		
		//get current hour of the day
		hour=date.getHours();
		
		//generate wish message
		if(hour<12)
			return "good morning "+user;
		else if(hour<16)
			return "good afternoon "+user;
		else if(hour<20)
			return "good evening"+user;
		else
			return "good night"+user;
	}
}
