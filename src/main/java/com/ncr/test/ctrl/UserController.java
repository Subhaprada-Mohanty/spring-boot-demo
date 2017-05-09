package com.ncr.test.ctrl;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.test.bo.UserBO;
import com.ncr.test.utils.UserBOValidator;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody @Valid UserBO userBo, Errors error) {
		
		new UserBOValidator().validate(userBo, error);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
