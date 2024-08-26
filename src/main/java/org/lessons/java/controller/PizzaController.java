package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.model.Pizza;
import org.lessons.java.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repo;
	
	
	@GetMapping()
	public String index(Model model) {
		
		
		List<Pizza> pizze = repo.findAll();
		
		model.addAttribute("pizze", pizze);
		
		return "/pizze/index";
	}

}
