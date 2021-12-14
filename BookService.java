package com.webservice.service;

import javax.ws.rs.core.Response;

public interface BookService {
	public Response getBooks( String year, String author, String country) ;
}
