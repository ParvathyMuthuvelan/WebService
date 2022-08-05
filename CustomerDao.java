package com.webservice.dao;

import java.util.List;

import com.webservice.model.Customer;


public interface CustomerDao {
	public boolean addCustomer(Customer c);

	public boolean deleteCustomer(int id);

	public Customer getCustomer(int id);

	public List<Customer> getAllCustomers();
}
