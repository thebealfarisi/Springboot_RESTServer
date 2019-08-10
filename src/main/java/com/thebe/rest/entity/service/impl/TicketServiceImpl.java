package com.thebe.rest.entity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thebe.rest.entity.Ticket;
import com.thebe.rest.entity.service.TicketService;
import com.thebe.rest.repository.TicketRepository;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ticket findById(Integer ticketId) {
		// TODO Auto-generated method stub
		Optional<Ticket> tick = ticketRepository.findById(ticketId);
		
		if (tick.isPresent()) {
			return tick.get();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Ticket> getTicketByFilm(String film) {
		// TODO Auto-generated method stub
		return ticketRepository.ticketAutoComplete(film, new PageRequest(0, 5));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ticket store(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.delete(ticket);
	}

}
