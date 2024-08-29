package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.model.Pizza;
import org.lessons.java.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repo;
	
	
	@GetMapping()
    public String index(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Pizza> pizze;
        if (search != null && !search.isEmpty()) {
            pizze = repo.findByNameContainingIgnoreCase(search);
        } else {
            pizze = repo.findAll();  // Recupera tutte le pizze
        }
        
        model.addAttribute("pizze", pizze);
        model.addAttribute("search", search);  // Mantieni il valore di ricerca nel modello
        
        return "/pizze/index";
    }

	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", repo.findById(id).get());
		return "/pizze/show";
	}
	
	

}
