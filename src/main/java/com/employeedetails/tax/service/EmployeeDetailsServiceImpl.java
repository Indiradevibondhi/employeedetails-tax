package com.employeedetails.tax.service;

import java.util.Objects;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.employeedetails.tax.entity.Employee;
import com.employeedetails.tax.exception.BusinessException;
import com.employeedetails.tax.repo.EmployeeRepository;
import com.employeedetails.tax.vo.EmployeeDetails;

public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    
	@Autowired
	EmployeeRepository repository;
	
	@Override
	public boolean saveEmployeeDeatils(EmployeeDetails details) throws Exception {
		if(Objects.nonNull(details)) {
			validateEmployeeDetails(details);
			Employee emp = new Employee();
			emp.setEmployeeId(details.getEmployeeId());
			emp.setFirstName(details.getFirstName());
			emp.setLastName(details.getLastName());
			emp.setEmail(details.getEmail());
			emp.setDOJ(details.getDOJ());
			emp.setPhoneNumbers(details.getPhoneNumbers());
			emp.setSalary(details.getSalary());
			repository.save(emp);
		}
		return false;
	}
	
	public void validateEmployeeDetails(EmployeeDetails details) {
		
		if(Objects.isNull(details.getEmployeeId())) {
			
			throw BusinessException.create("EmployeeId cannot be Blank");
		}
		
		if (Objects.isNull(details.getFirstName())) {

			throw BusinessException.create("FirstName cannot be Blank");
		}

		if (Objects.isNull(details.getLastName())) {

			throw BusinessException.create("LastName cannot be Blank");
		}

		if (Objects.isNull(details.getEmail())) {

			throw BusinessException.create("Email cannot be Blank");
		}

		if (Objects.isNull(details.getDOJ())) {

			throw BusinessException.create("Date Of Joing cannot be Blank");
		}

		if (details.getPhoneNumbers().isEmpty()) {

			throw BusinessException.create("PhoneNumbers cannot be Empty");
		}

		if (Objects.isNull(details.getSalary())) {

			throw BusinessException.create("Salary cannot be Blank");
		}
	}

	@Override
	public EmployeeDetails getEmployeeDetails(long employeeid) throws Exception {
		
		if(Objects.nonNull(employeeid)) {
			
		 Employee employee= repository.getById(employeeid);
		 
		 if(Objects.nonNull(employee)) {
			 
			 EmployeeDetails details = new EmployeeDetails();
			 
			 details.setEmployeeId(employee.getEmployeeId());
			 details.setFirstName(employee.getFirstName());
			 details.setLastName(employee.getLastName());
			 details.setEmail(employee.getEmail());
			 details.setDOJ(employee.getDOJ());
			 details.setPhoneNumbers(employee.getPhoneNumbers());
			 details.setSalary(employee.getSalary());
			 return details;

		 }
		}
		return null;
	}

}
