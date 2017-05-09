package com.ncr.test.dto;

import java.io.Serializable;
import java.util.List;

public class FieldErrorDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	List<ErrorDTO> errors;

	public List<ErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDTO> errorDtos) {
		this.errors = errorDtos;
	}
	
	
}
