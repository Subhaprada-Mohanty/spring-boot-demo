package com.ncr.test.bo;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)

public class UserBO implements Serializable {
	
	/*@NotNull
	@NotEmpty
	@Size(min=2,max=100)
	String fname;
	
	@NotNull
	@NotEmpty
	@Size(min=2,max=100)
	String lname;*/
	
	@NotNull(message="cannot be null")
	@NotEmpty(message="cannot be empty")
	@Size(min=2,max=100)
	String email;
	
	/*@NotNull
	@NotEmpty
	@Size(min=10,max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	String mobile;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}*/
	
	

}
