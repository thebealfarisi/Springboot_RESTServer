package com.thebe.rest.process.service;

import java.util.List;
import java.util.Optional;

import com.thebe.rest.entity.Customer;
import com.thebe.rest.entity.Order;
import com.thebe.rest.entity.Ticket;

public interface TicketOrderService {

	/**
	 * Method to get {@link Customer} data by name
	 * @param name name of {@link Customer}
	 * @return {@link Customer} data
	 */
	public Customer getCustomerData(String name);
	
	/**
	 * Method to get {@link Customer} by Id
	 * @param customerId {@link Customer}'s id
	 * @return {@link Customer} data
	 */
	public Optional<Customer> findCustomerById(Integer customerId);
	
	/**
	 * Method to get {@link Ticket} data by name
	 * @param film name of the film
	 * @return {@link Ticket} data
	 */
	public Ticket getTicketData(String film);
	
	/**
	 * Method to get {@link Ticket} by Id
	 * @param ticketId {@link Ticket}'s id
	 * @return {@link Ticket} data
	 */
	public Optional<Ticket> findTicketById(Integer ticketId);
	
	/**
	 * Method to show all {@link Order}'s data
	 * @return {@link List} of {@link Order}
	 */
	public List<Order> getAllOrders();
	
	/**
	 * Method to get {@link Order} by Id
	 * @param orderId {@link Order}'s id
	 * @return {@link Order} data
	 */
	public Optional<Order> findOrderById(Integer orderId);
	
}
