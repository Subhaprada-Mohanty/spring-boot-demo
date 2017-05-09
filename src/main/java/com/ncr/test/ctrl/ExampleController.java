package com.ncr.test.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.test.bo.UserBO;
import com.ncr.test.dto.ErrorDTO;
import com.ncr.test.dto.FieldErrorDto;
import com.ncr.test.utils.UserBOValidator;


@RestController
@RequestMapping("/ex")
public class ExampleController {
	

	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String home() {
		return "hello world";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody @Valid UserBO userBo, BindingResult error) {
		
		
		if (!error.hasErrors()) {
			new UserBOValidator().validate(userBo, error);
		}
		
		if (error.hasErrors()) {
			System.out.println("error" + error.getErrorCount());
			FieldErrorDto dto = new FieldErrorDto();
			buildError(error,dto);
			return ResponseEntity.badRequest().body(dto);
		} 
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private void buildError(BindingResult error,FieldErrorDto dto) {
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
