package com.webservice.service;



import java.util.List;

import com.webservice.model.Book;

public interface BookService {
//	public Response getBooks( int year, String author, String country) ;
	public List<Book> getBooks( int year, String author, String country) ;
}