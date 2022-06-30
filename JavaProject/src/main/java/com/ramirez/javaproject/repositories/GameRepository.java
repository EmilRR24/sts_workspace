package com.ramirez.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.models.Gamer;

@Repository
public interface GameRepository extends CrudRepository<Game,Long>{
	List<Game> findAll();
	
	Game findByUpdatedAtIsNullAndGamer(Gamer gamer);
	
	List<Game> findByCompletedIsNullAndUpdatedAtIsNotNull();
	
	List<Game> findByCompletedIsNull();
	
	List<Game> findTop5ByUpdatedAtIsNotNullOrderByIdDesc();
}
