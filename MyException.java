package com.webservice.service;

import javax.ws.rs.WebApplicationException;
public class MyException extends WebApplicationException {
	String message;
	
public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	    public MyException() {
        super();
    }
    public MyException(String message) {
        this.message=message;
    }
}
