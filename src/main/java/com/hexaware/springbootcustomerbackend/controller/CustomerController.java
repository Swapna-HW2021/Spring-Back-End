package com.hexaware.springbootcustomerbackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springbootcustomerbackend.entity.Customer;
import com.hexaware.springbootcustomerbackend.exception.CustomerNotFoundException;
import com.hexaware.springbootcustomerbackend.service.CustomerService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}


	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer newCustomer) {
		// TODO Auto-generated method stub
		return customerService.createCustomer(newCustomer);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long custId) throws CustomerNotFoundException {
		return customerService.getCustomerById(custId);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable("id")  Long custId) throws CustomerNotFoundException {
		return customerService.deleteCustomer(custId);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer updateCustomer,
								@PathVariable("id") Long id) throws CustomerNotFoundException {
	
		return customerService.updateCustomer(updateCustomer, id);
	}

}
