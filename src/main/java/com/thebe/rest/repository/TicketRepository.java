package com.thebe.rest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thebe.rest.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	/**
	 * Method to get {@link Ticket} data by name
	 * @param film name of the film
	 * @return {@link Ticket} data
	 */
	@Query("SELECT t FROM Ticket t WHERE LOWER(t.film) LIKE LOWER(CONCAT('%', :film, '%')) AND t.date >= CURRENT_DATE")
	List<Ticket> ticketAutoComplete(@Param("film") String film, Pageable pageable);
	
}
