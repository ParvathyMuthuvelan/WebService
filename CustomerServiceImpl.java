package com.webservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.webservice.dao.CustomerDao;
import com.webservice.dao.CustomerDaoImpl;
import com.webservice.model.Customer;
import com.webservice.model.Response;
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerServiceImpl  implements CustomerService{
     private CustomerDao custDao=new CustomerDaoImpl();
	@Override
	@POST
	@Path("/add")
	public Response addCustomer(Customer c) {
	Response response=new Response();
	boolean result=custDao.addCustomer(c);
		if(result)
		{response.setStatus(result);
		response.setMessage("Customer created successfully");
		}
		else
		{
			response.setStatus(result);
			response.setMessage("Problem while inserting...");
		}
		return response;
	}

	@Override
	public Response deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> custList=custDao.getAllCustomers();
		return custList;
	}

	@Override
	@PUT
	@Path("update")
	public Response updateCustomer(Customer c) {
		Response response=new Response();
	boolean result=custDao.updateCustomer(c);
	if(result)
	{response.setStatus(result);
	response.setMessage("Customer updated successfully");
	}
	else
	{
		response.setStatus(result);
		response.setMessage("Problem while inserting...");
	}
	return response;
	}

}
