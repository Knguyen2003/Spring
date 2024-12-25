package com.fit.dao;

import java.util.List;

import com.fit.entities.Customer;

public interface CustomerDao {
   public List<Customer> getAllCustomers();
   public Customer getCustomerById(int customerId);
   public void addCustomer(Customer customer);
   public void updateCustomer(Customer customer);
   public void deleteCustomer(int customerId);
}
