package com.thebe.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thebe.rest.entity.Customer;
import com.thebe.rest.entity.Order;
import com.thebe.rest.entity.Ticket;
import com.thebe.rest.entity.service.CustomerService;
import com.thebe.rest.entity.service.OrderService;
import com.thebe.rest.entity.service.TicketService;
 
@RestController
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TicketOrderingController {

	@Autowired
	CustomerService customerService;

	@Autowired
	TicketService ticketService;

	@Autowired
	OrderService orderService;

	// GET ALL CUSTOMER
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();

		try {
			customers = customerService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	// GET CUSTOMER BY NAME
	@RequestMapping(value = "/customerName_{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> listCustomerByName(@PathVariable("name") String name) {
		List<Customer> customers = new ArrayList<Customer>();

		try {
			customers = customerService.getByCustomerName(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	// GET CUSTOMER BY ID
	@RequestMapping(value = "/customerId_{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Customer customer = new Customer();
		HttpStatus httpStatus = null;

		try {
			customer = customerService.findById(id);
			if (customer != null) {
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<Customer>(customer, httpStatus);
	}

	// GET ALL TICKET
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> getAllTickets() {
		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
			tickets = ticketService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}

	// GET TICKET BY NAME
	@RequestMapping(value = "/ticketName_{film}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> listTicketByName(@PathVariable("film") String film) {
		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
			tickets = ticketService.getTicketByFilm(film);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}

	// GET TICKET BY ID
	@RequestMapping(value = "/ticketId_{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id) {
		Ticket ticket = new Ticket();
		HttpStatus httpStatus = null;

		try {
			ticket = ticketService.findById(id);
			if (ticket != null) {
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<Ticket>(ticket, httpStatus);
	}

	// GET ALL ORDER
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();

		try {
			orders = orderService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/order_{buy}&ticket_{tick}&customer_{cust}", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrder(@PathVariable("buy") Integer buy, @PathVariable("tick") Integer tick, @PathVariable("cust") Integer cust) {
		Order order = new Order();
		try {
			order.setBuy(buy);
			order.setTicketId(tick);
			
			Ticket ticket = ticketService.findById(tick);
			if (ticket != null) {
				Integer currentTicket = ticket.getQuantity();
				ticket.setQuantity(currentTicket - buy);
				ticketService.store(ticket);
			}
			
			order.setCustomerId(cust);
			
			order = orderService.store(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
