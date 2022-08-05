package com.webservice.service;

import java.util.List;

import com.webservice.model.Customer;
import com.webservice.model.Response;

public interface CustomerService {
	public Response addCustomer(Customer c);

	public Response deleteCustomer(int id);

	public Customer getCustomer(int id);

	public List<Customer> getAllCustomers();
	
	public Response updateCustomer(Customer c);
}
