package com.fit.dao;

import com.fit.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<Customer> getAllCustomers() {
		return entityManager.createQuery("from Customer order by lastName", Customer.class).getResultList();
	}

	@Override

	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.merge(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
       entityManager.merge(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
       	Customer customer = entityManager.find(Customer.class, customerId);
		if (customer != null) {
			entityManager.remove(customer);
		}
	}
}
