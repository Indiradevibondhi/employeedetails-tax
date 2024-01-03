package com.employeedetails.tax.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.employeedetails.tax.entity.Employee;
import com.employeedetails.tax.vo.EmployeeDetails;
import com.employeedetails.tax.vo.EmployeeTaxResponseVO;

public class EmployeeTaxCalServiceImpl implements EmployeeTaxCalService {
	@Autowired
	EmployeeDetailsService empDetails;

	@Override
	public EmployeeDetails calculateTax(long employeeid) {
		EmployeeDetails employee = null;
		if(Objects.nonNull(employeeid)) {
			try {
				employee = empDetails.getEmployeeDetails(employeeid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long tax=0L;
			long cess=0L;
			if(Objects.nonNull(employee)) {
				double yearlySalary = employee.getSalary()*12;
				if(yearlySalary >= 2500000) {
					cess = (long) (0.02*yearlySalary);
				}
				if(yearlySalary > 250000) {
					yearlySalary = yearlySalary - 250000;
				}
				
				if(yearlySalary >= 250001) {
					yearlySalary = yearlySalary - 250000;
					tax = tax + 12500;
					if(yearlySalary > 500000) {
						yearlySalary = yearlySalary - 250000;
		                 tax = (long) (0.1*yearlySalary+tax);
		                 if(yearlySalary > 1000000) {
		                	tax = (long) (0.2*yearlySalary+tax);
		                 }
					}
				}
				
				EmployeeTaxResponseVO response = new EmployeeTaxResponseVO();
				response.setEmployeecode(employee.getEmployeeId());
				response.setFirstname(employee.getFirstName());
				response.setLastname(employee.getLastName());
				response.setTaxamount(tax);
				response.setYearlysalary((long) (employee.getSalary()*12));
				response.setCessamount(cess);
			}
		}
		return null;
	}
	
}
