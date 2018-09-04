package com.model;

public class Passport {

	private Integer pptNumber;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPptNumber() {
		return pptNumber;
	}
	@Override
	public String toString() {
		return "Passport [pptNumber=" + pptNumber + ", city=" + city + "]";
	}

	public void setPptNumber(Integer pptNumber) {
		this.pptNumber = pptNumber;
	}
	
	
}
