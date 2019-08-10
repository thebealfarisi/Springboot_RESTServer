package com.thebe.rest.entity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thebe.rest.entity.Customer;
import com.thebe.rest.entity.service.CustomerService;
import com.thebe.rest.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findById(Integer customerId) {
		// TODO Auto-generated method stub
		
		Optional<Customer> cust = customerRepository.findById(customerId);
		
		if (cust.isPresent()) {
			return cust.get();
		} else {
			return null;
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Customer> getByCustomerName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.customerAutoComplete(name, new PageRequest(0, 5));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer store(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
	}

}
