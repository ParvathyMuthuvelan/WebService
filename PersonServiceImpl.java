package com.webservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.webservice.model.Person;
import com.webservice.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {
//http://localhost:8080/RestWebService/person/add
	// http://localhost:8080/RestWebService/person/getPerson?paramname=paramvalue&paramname1=value1
	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

	@Override
	@POST
	@Path("/add")
	public Response addPerson(Person p) {
		Response response = new Response();
		if (persons.get(p.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@Override
	@DELETE
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if (persons.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}

	@GET
	@Path("/getDummy/{id}")
	//public Person getDummyPerson(@PathParam("id") int id, @QueryParam("param") String param) {
	public Person getDummyPerson(@PathParam("id") int id)
	{
		Person p = new Person();
		p.setAge(99);
		p.setName("sai");
		p.setId(id);
		return p;
	}

	@GET
	@Path("/getByAge")
	public List<Person> getPersonByAge(@QueryParam("minAge") int minAge, @QueryParam("maxAge") int maxAge) {
		Set<Integer> ids = persons.keySet();
		List<Person> list = new ArrayList<>();

		Person obj = new Person();

		for (Integer id : ids) {
			obj = persons.get(id);
			if (obj.getAge() >= minAge && obj.getAge() <= maxAge) {
				list.add(obj);
			}
		}
		return list;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

	@Override
	@PUT
	@Path("/{id}/update")
	public Response updatePerson(@PathParam("id") int id, Person p) {
		Response response = new Response();
		if (persons.get(id) != null) {
			persons.put(id, p);
			response.setStatus(true);
			response.setMessage("Person updated successfully");

		} else {
			response.setStatus(false);
			response.setMessage("Person not found");
		}
		return response;
	}

}
