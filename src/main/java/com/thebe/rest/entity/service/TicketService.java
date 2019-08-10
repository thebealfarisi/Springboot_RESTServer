package com.thebe.rest.entity.service;

import java.util.List;

import com.thebe.rest.entity.Ticket;

public interface TicketService {
	
	/**
	 * Method to get {@link List} of {@link Ticket}
	 * @return {@link List} of {@link Ticket}
	 */
	public List<Ticket> getAll();
	
	/**
	 * Method to get {@link Ticket} by Id
	 * @param ticketId {@link Ticket}'s id
	 * @return {@link Ticket} data
	 */
	public Ticket findById(Integer ticketId);
	
	/**
	 * Method to get {@link List} of {@link Ticket} by film
	 * @param film {@link Ticket}'s film
	 * @return {@link List} of {@link Ticket}
	 */
	public List<Ticket> getTicketByFilm(String film);
	
	/**
	 * Method to store {@link Ticket} data
	 * @param ticket {@link Ticket} data
	 * @return {@link Ticket} data
	 */
	public Ticket store(Ticket ticket);
	
	/**
	 * Method to delete {@link Ticket} data
	 * @param ticket {@link Ticket} data
	 */
	public void delete(Ticket ticket);

}
