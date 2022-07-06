package com.gl.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gl.spring.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCustomer(Customer custome) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(custome);
		logger.info("Customer saved successfully, Customer Details=" + custome);
	}

	@Override
	public void updateCustomer(Customer custome) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(custome);
		logger.info("Customer updated successfully, Customer Details=" + custome);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomeres() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customesList = session.createQuery("from Customer").list();
		for (Customer customer : customesList) {
			logger.info("Person List::" + customer);
		}
		return customesList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Custome loaded successfully, Person details=" + customer);
		return customer;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if (null != customer) {
			session.delete(customer);
		}
		logger.info("Customer deleted successfully, person details=" + customer);
	}

}