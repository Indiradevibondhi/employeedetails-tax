package com.employeedetails.tax.service;

import com.employeedetails.tax.vo.EmployeeDetails;

public interface EmployeeTaxCalService {

	public EmployeeDetails calculateTax(long employeeid);
}
