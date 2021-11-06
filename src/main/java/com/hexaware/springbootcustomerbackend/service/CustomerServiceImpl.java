package com.hexaware.springbootcustomerbackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.springbootcustomerbackend.entity.Customer;
import com.hexaware.springbootcustomerbackend.exception.CustomerNotFoundException;
import com.hexaware.springbootcustomerbackend.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(Long custId) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(custId).
				orElseThrow(() -> new CustomerNotFoundException("Customer does not exist with id = " + custId));
		return ResponseEntity.ok(customer);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(Long custId) throws CustomerNotFoundException {
		Customer delCustomer = customerRepository.findById(custId).
				orElseThrow(() -> new CustomerNotFoundException("Customer does not exist with id = " + custId));
		customerRepository.delete(delCustomer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Customer updateCustomer, Long id) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(id).
				orElseThrow(() -> new CustomerNotFoundException("Customer does not exist with id = " + id));
		customer.setFirstName(updateCustomer.getFirstName());
		customer.setLastName(updateCustomer.getLastName());
		customer.setEmail(updateCustomer.getEmail());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

}
