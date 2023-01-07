package com.cafejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafejava.models.Drink;
import com.cafejava.repositories.DrinkRepository;

@Service
public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	public Drink getOne(Long id) {
		Optional<Drink> optDrink = drinkRepo.findById(id);
		if(optDrink.isPresent()) {
			return optDrink.get();
		} else {
			return null;
		}

	}

	public Drink create(Drink d) {
		return drinkRepo.save(d);
	}
	
	public List<Drink> getAll(){
		return drinkRepo.findAll();
	}
	
	public Drink update(Drink d) {
		return drinkRepo.save(d);
	}

	public void deleteById(Long id) {
		drinkRepo.deleteById(id);
	}
	
}
