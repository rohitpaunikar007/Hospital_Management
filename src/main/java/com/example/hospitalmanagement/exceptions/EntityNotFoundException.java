package com.example.hospitalmanagement.exceptions;

public class EntityNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String entityName, Long id) {
        super(entityName + " with ID " + id + " not found");
    }
}

