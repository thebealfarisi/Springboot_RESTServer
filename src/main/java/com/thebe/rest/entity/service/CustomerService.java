package com.thebe.rest.entity.service;

import java.util.List;

import com.thebe.rest.entity.Customer;

public interface CustomerService {
	
	/**
	 * Method to get {@link List} of {@link Customer}
	 * @return {@link List} of {@link Customer}
	 */
	public List<Customer> getAll();
	
	/**
	 * Method to get {@link Customer} by Id
	 * @param customerId {@link Customer}'s id
	 * @return {@link Customer} data
	 */
	public Customer findById(Integer customerId);
	
	/**
	 * Method to get {@link List} of {@link Customer} by name
	 * @param name {@link Customer}'name
	 * @return {@link List} of {@link Customer} data
	 */
	public List<Customer> getByCustomerName(String name);
	
	/**
	 * Method to store {@link Customer} data
	 * @param customer {@link Customer} data
	 * @return {@link Customer} data
	 */
	public Customer store(Customer customer);
	
	/**
	 * Method to delete {@link Customer} data
	 * @param customer {@link Customer} data
	 */
	public void delete(Customer customer);
	
}
