package com.employeedetails.tax.exception;

public class BusinessException extends RuntimeException {
    
	String message;

	public BusinessException(String message2) {
		// TODO Auto-generated constructor stub
	}

	public static BusinessException create(final String message) {
		
		return new BusinessException(message);
	}
}
