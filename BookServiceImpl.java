package com.webservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookServiceImpl implements BookService {
//http://localhost:8080/RestWebService/books/2011;country=malaysia;author=Gosling
	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response
			.status(200)
			.entity("getBooks is called, year : " + year
				+ ", author : " + author + ", country : " + country)
			.build();

	}

}