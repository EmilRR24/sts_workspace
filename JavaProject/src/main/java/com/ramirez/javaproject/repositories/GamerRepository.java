package com.ramirez.javaproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.javaproject.models.Gamer;

@Repository
public interface GamerRepository extends CrudRepository<Gamer,Long>{
	List<Gamer> findAll();
	
	// CUSTOM QUERY
	// find by stream
	Optional<Gamer> findByStream(String stream);
}
