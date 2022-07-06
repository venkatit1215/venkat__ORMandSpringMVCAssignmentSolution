package com.gl.spring.dao;

import java.util.List;

import com.gl.spring.model.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer p);

	public void updateCustomer(Customer p);

	public List<Customer> listCustomeres();

	public Customer getCustomerById(int id);

	public void removeCustomer(int id);
}
