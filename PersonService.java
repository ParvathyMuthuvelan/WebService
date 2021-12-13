package com.webservice.service;

import java.util.List;

import javax.ws.rs.QueryParam;

import com.webservice.model.Person;
import com.webservice.model.Response;

public interface PersonService {

	public Response addPerson(Person p);

	public Response deletePerson(int id);
	
	public Response updatePerson(int id,Person p);

	public Person getPerson(int id);
	
	public List<Person> getPersonByAge( int minAge, int maxAge);

	public Person[] getAllPersons();

}
