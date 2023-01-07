package com.cafejava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafejava.models.Drink;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long>{
	public List<Drink> findAll();
	
}
