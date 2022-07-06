package com.gl.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gl.spring.dao.CustomerDAOImpl;
import com.gl.spring.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAOImpl customeDAOImpl;

	public void setCustomeDAOImpl(CustomerDAOImpl customeDAOImpl) {
		this.customeDAOImpl = customeDAOImpl;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		this.customeDAOImpl.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		this.customeDAOImpl.updateCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> listCustomeres() {
		return this.customeDAOImpl.listCustomeres();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customeDAOImpl.getCustomerById(id);
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		this.customeDAOImpl.removeCustomer(id);
	}

}
