package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.pojo.Customer;

public interface CustomerDao {
	
	boolean registerCustomer(Customer customer);
    Customer login(String email, String password);
    int getCountOfCustomer();
    boolean updateVisitorCounter(int id, int count);
    int getVisitorCounter();
    boolean addVisitorCounter();
    int getCountOfVisitorDetail();
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    List<Customer> getCustomerByName(String name);
}
