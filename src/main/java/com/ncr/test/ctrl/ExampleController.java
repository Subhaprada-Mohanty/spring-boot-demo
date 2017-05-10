package com.ncr.test.ctrl;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.test.bo.UserBO;
import com.ncr.test.dto.FieldErrorDto;
import com.ncr.test.helper.UserValidationHelper;
import com.ncr.test.utils.UserBOValidator;


@RestController
@RequestMapping("/ex")
public class ExampleController {
	
	@Autowired
     private UserValidationHelper uservalidationHelper;
	
	private static Logger log = LogManager.getLogger(ExampleController.class);
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String home() {
		log.info("logger for ::: {}",new String("home"));
		return "hello world";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserBO userBo, BindingResult error) {

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = vf.getValidator();
		Set<ConstraintViolation<UserBO>> constraints = validator.validate(userBo);
		if (constraints != null && constraints.size() > 0) {
			uservalidationHelper.buildBindingResultFromConstraint(error, constraints);
		}
		if (!error.hasErrors()) {
			new UserBOValidator().validate(userBo, error);
		}

		if (error.hasErrors()) {
			System.out.println("error" + error.getErrorCount());
			FieldErrorDto dto = new FieldErrorDto();
			uservalidationHelper.buildError(error, dto);
			return ResponseEntity.badRequest().body(dto);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	

	


}
