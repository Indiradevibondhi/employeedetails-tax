package com.employeedetails.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.tax.service.EmployeeDetailsService;
import com.employeedetails.tax.vo.EmployeeDetails;

@RestController
public class EmployeeDetailsController {
  
	@Autowired
	EmployeeDetailsService service;
	
	public void saveEmployeeDetails(@RequestBody EmployeeDetails details) throws Exception {
		service.saveEmployeeDeatils(details);
		
	}
}
