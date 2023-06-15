package com.example.hospitalmanagement.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String feildName;
	long feildValue;
	
	public ResourceNotFoundException(String resourceName, String feildName, long feildValue) {
		super(String.format("%s not found with %s : %1", resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
}
