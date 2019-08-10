package com.thebe.rest.entity.service;

import java.util.List;

import com.thebe.rest.entity.Order;

public interface OrderService {

	/**
	 * Method to get {@link List} of {@link Order}
	 * @return {@link List} of {@link Order}
	 */
	public List<Order> getAll();
	
	/**
	 * Method to get {@link Order} by Id
	 * @param orderId {@link Order}'s id
	 * @return {@link Order} data
	 */
	public Order findById(Integer orderId);
	
	/**
	 * Method to store {@link Order} data
	 * @param order {@link Order} data
	 * @return {@link Order} data
	 */
	public Order store(Order order);
	
	/**
	 * Method to delete {@link Order} data
	 * @param order {@link Order} data
	 */
	public void delete(Order order);
	
}
