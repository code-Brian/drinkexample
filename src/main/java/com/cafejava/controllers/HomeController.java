package com.cafejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafejava.models.Drink;
import com.cafejava.services.DrinkService;

@Controller
public class HomeController {

	@Autowired
	private DrinkService drinkServ;
	
	@GetMapping("/")
	public String index(Model model) {
		// Go to database, get all drinks
		List<Drink> allDrinks = drinkServ.getAll();
		// Store all drinks as List
		// Pass List to Model
		model.addAttribute("allDrinks", allDrinks);
		
		return "index.jsp";
	}
	

}
