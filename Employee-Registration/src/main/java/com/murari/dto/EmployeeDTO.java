package com.murari.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{

	private String ename;
	private int edept;
	private String eadd;
	private float basicSal;
	
	//setters and getters
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEdept() {
		return edept;
	}
	public void setEdept(int edept) {
		this.edept = edept;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public float getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(float basicSal) {
		this.basicSal = basicSal;
	}
	
	
}
