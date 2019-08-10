package com.thebe.rest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thebe.rest.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/**
	 * Method to get {@link Customer} data by name
	 * @param name name of {@link Customer}
	 * @return {@link Customer} data
	 */
	@Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<Customer> customerAutoComplete(@Param("name") String name, Pageable pageable);
	
}
