package com.ncr.test.utils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ncr.test.bo.UserBO;

public class UserBOValidator implements Validator {
  static final String EMAIL="sm@gmail.com";
  static final String MNUM = "9582105618";
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UserBO.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		System.out.println("customize validation is going on");
		if (arg0 instanceof UserBO) {
		  UserBO user = (UserBO) arg0;
		  if (user.getEmail().equalsIgnoreCase(EMAIL)) {
			  
			  error.rejectValue("email","UserBo.email","Email already exists.");
		  }
		} 
		
	}

}
