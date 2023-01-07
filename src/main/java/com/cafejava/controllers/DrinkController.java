package com.cafejava.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafejava.models.Drink;
import com.cafejava.services.DrinkService;

@Controller
@RequestMapping("/drink")
public class DrinkController {
	
	@Autowired
	private DrinkService drinkServ;
	
	@GetMapping("/create")
	public String newDrink(@ModelAttribute("drink") Drink drink) {
		// using model attribute creates a new, blank drink object. Good in this case, but see the edit case below for why it isn't.
		return "newDrink.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("drink") Drink drink, BindingResult result) {
		if(result.hasErrors()) {
			return "newDrink.jsp";
		} else {
			drinkServ.create(drink);
			return "redirect:/";
		}
		
	}
	
	/*
	 * @GetMapping("/{id}/delete") public String delete(@PathVariable("id") Long id)
	 * { drinkServ.deleteById(id); return "redirect:/"; }
	 */
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		drinkServ.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/update")
	public String editForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("drink",drinkServ.getOne(id));
		return "editDrink.jsp";
	}
	
	@PutMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("drink") Drink drink, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editDrink.jsp";
		} else {
			drink.setId(id);
			drinkServ.update(drink); 
			return "redirect:/";
		}
	}
	
}
