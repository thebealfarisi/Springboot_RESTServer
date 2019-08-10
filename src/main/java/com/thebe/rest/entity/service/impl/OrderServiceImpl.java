package com.thebe.rest.entity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebe.rest.entity.Order;
import com.thebe.rest.entity.service.OrderService;
import com.thebe.rest.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order findById(Integer orderId) {
		// TODO Auto-generated method stub
		
		Optional<Order> ord = orderRepository.findById(orderId);
		
		if (ord.isPresent()) {
			return ord.get();
		} else {
			return null;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order store(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		orderRepository.delete(order);
	}

}
