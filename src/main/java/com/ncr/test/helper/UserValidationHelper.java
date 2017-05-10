package com.ncr.test.helper;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.ncr.test.bo.UserBO;
import com.ncr.test.dto.ErrorDTO;
import com.ncr.test.dto.FieldErrorDto;

@Component
public class UserValidationHelper {
	
	public void buildBindingResultFromConstraint(BindingResult error, Set<ConstraintViolation<UserBO>> constraints) {
		for (ConstraintViolation<UserBO> violation : constraints) {
			FieldError fe = new FieldError("User", violation.getPropertyPath().toString(), violation.getMessage());
			error.addError(fe);
		}
		
	}
	public void buildError(BindingResult error,FieldErrorDto dto) {
		List<ErrorDTO> errosList = new ArrayList<ErrorDTO>();
		//StringBuilder sb = new StringBuilder();
		for (FieldError oerror : error.getFieldErrors()) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setAttr(oerror.getField());
			errorDTO.setMessage(oerror.getDefaultMessage());
			errosList.add(errorDTO);
		}
		dto.setErrors(errosList);
		
	}
}

