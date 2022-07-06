package com.gl.spring.service;

import java.util.List;

import com.gl.spring.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomeres();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
	
}