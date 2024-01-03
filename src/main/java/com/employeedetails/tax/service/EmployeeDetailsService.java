package com.employeedetails.tax.service;

import com.employeedetails.tax.entity.Employee;
import com.employeedetails.tax.vo.EmployeeDetails;

public interface EmployeeDetailsService {

	boolean saveEmployeeDeatils(EmployeeDetails details) throws Exception;
	EmployeeDetails getEmployeeDetails(long employeeid) throws Exception;
}
