package com.ramirez.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.safetravels.models.Travel;

@Repository
public interface TravelRespository extends CrudRepository<Travel, Long> {
	//Retrieve all travels
	List<Travel> findAll();
}
