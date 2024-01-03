package com.employeedetails.tax.vo;

public class EmployeeTaxResponseVO {

	private String employeecode; 
	
	private String firstname;
	
	private String lastname; 
	
	private long yearlysalary;
	
	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getYearlysalary() {
		return yearlysalary;
	}

	public void setYearlysalary(long yearlysalary) {
		this.yearlysalary = yearlysalary;
	}

	public long getTaxamount() {
		return taxamount;
	}

	public void setTaxamount(long taxamount) {
		this.taxamount = taxamount;
	}

	public long getCessamount() {
		return cessamount;
	}

	public void setCessamount(long cessamount) {
		this.cessamount = cessamount;
	}

	private long taxamount;
	
	private long cessamount;
}
