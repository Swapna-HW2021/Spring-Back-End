package com.hexaware.springbootcustomerbackend.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.hexaware.springbootcustomerbackend.entity.Customer;
import com.hexaware.springbootcustomerbackend.exception.CustomerNotFoundException;

public interface CustomerService {
	
	List<Customer> getAllCustomers();

	Customer createCustomer(Customer newCustomer);

	ResponseEntity<Customer> getCustomerById(Long custId) throws CustomerNotFoundException;

	ResponseEntity<Map<String,Boolean>>  deleteCustomer(Long custId)throws CustomerNotFoundException;

	ResponseEntity<Customer>  updateCustomer(Customer newCustomer, Long id) throws CustomerNotFoundException;
}
