package com.thebe.rest.process.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thebe.rest.entity.Customer;
import com.thebe.rest.entity.Order;
import com.thebe.rest.entity.Ticket;
import com.thebe.rest.process.service.TicketOrderService;
import com.thebe.rest.repository.CustomerRepository;
import com.thebe.rest.repository.OrderRepository;
import com.thebe.rest.repository.TicketRepository;

@Service("ticketOrderService")
public class TicketOrderServiceImpl implements TicketOrderService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Customer getCustomerData(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Optional<Customer> findCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Ticket getTicketData(String film) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Optional<Ticket> findTicketById(Integer ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Optional<Order> findOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}

}
