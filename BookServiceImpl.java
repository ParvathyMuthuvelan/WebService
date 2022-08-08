package com.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.webservice.model.Book;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class BookServiceImpl implements BookService {
//http://localhost:8080/RestWS/books/2011;country=malaysia;author=Gosling
	static List<Book> bookList = new ArrayList<>();
static
{
	
	Book b = new Book("James", "US", 1998);
	bookList.add(b);
	b = new Book("Gosling", "India", 2005);
	bookList.add(b);
	b = new Book("A", "malaysia", 2000);
	bookList.add(b);
	b = new Book("Gosling", "malaysia", 2002);
	bookList.add(b);
	b = new Book("C", "India", 2002);
	bookList.add(b);
}
	@GET
	@Path("{year}")
	public List<Book> getBooks(@PathParam("year") int year, @MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		List<Book> resultList = new ArrayList<>();
		Book b = new Book("James", "US", 1998);
		bookList.add(b);
		b = new Book("Gosling", "India", 2005);
		bookList.add(b);
		b = new Book("A", "malaysia", 2000);
		bookList.add(b);
		b = new Book("Gosling", "malaysia", 2002);
		bookList.add(b);
		b = new Book("C", "India", 2002);
		bookList.add(b);
		for (Book obj : bookList) {
			// if((obj.getAuthor().equals(author) || obj.getCountry().equals(country)) &&
			// (obj.getYear()==year))
			if ((obj.getAuthor().equals(author)) || (obj.getCountry().equals(country)))
				System.out.println(obj.getAuthor() + " " + obj.getCountry());
			resultList.add(obj);
		}
//		return Response.status(200)
//			
//			.entity("getBooks is called, year : " + year
//				+ ", author : " + author + ", country : " + country)
//			.build();
//		
		return resultList;

	}

	@GET
	@Path("/searchByAuthor")
	//http://localhost:8080/RestWS/books/searchByAuthor?author=Gosling
	public List<Book> searchByAuthor(@QueryParam("author") String author) {
		List<Book> resultList = new ArrayList<>();
		for (Book obj : bookList) {

			if (obj.getAuthor().equals(author))

				resultList.add(obj);
		}

		return resultList;

	}
	@GET
	@Path("/searchByBookAndAuthor")
	//http://localhost:8080/RestWS/books/searchByBookAndAuthor?author=Gosling&country=India
	public List<Book> searchByAuthorAndCountry(@QueryParam("author") String author,@QueryParam("country") String country) {
		List<Book> resultList = new ArrayList<>();
		for (Book obj : bookList) {

			if ((obj.getAuthor().equals(author)) && (obj.getCountry().equals(country)))
				resultList.add(obj);
		}

		return resultList;

	}
	@GET
	@Path("/searchByAuthors")
	//http://localhost:8080/RestWS/books/searchByAuthors?author=Gosling&author=James
	public List<Book> searchByAuthors(@QueryParam("author") List<String> author) {
		List<String> authorList=author;
		List<Book> resultList = new ArrayList<>();
		for (Book obj : bookList) {

			if ((obj.getAuthor().equals(authorList.get(0))) || (obj.getAuthor().equals(authorList.get(1))))
				resultList.add(obj);
		}

		return resultList;

	}
	@GET
	@Path("/searchByDefault")
	//http://localhost:8080/RestWS/books/searchByDefault?author=Gosling
	public List<Book> searchByDefault(@DefaultValue("James") @QueryParam("author") String author) {
	
		List<Book> resultList = new ArrayList<>();
		for (Book obj : bookList) {

			if (obj.getAuthor().equals(author) )
				resultList.add(obj);
		}

		return resultList;

	}
}
