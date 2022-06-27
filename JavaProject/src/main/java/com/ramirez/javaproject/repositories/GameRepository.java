package com.ramirez.javaproject.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.javaproject.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game,Long>{
	List<Game> findAll();
	
	List<Game> findByGameIsNotUpdated(Date updatedAt);
}
