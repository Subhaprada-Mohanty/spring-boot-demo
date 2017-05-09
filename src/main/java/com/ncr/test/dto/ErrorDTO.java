package com.ncr.test.dto;
import java.io.Serializable;

public class ErrorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	String  attr;
	String message;
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
