package com.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	private Integer empId;
	private String empName;
	private String company;
	@Autowired
	private Passport ppt;
	
	public Employee(Passport ppt){
		this.ppt = ppt;
	}
	
	public Passport getPpt() {
		return ppt;
	}
	public void setPpt(Passport ppt) {
		this.ppt = ppt;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
