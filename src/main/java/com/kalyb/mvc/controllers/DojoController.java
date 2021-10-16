package com.kalyb.mvc.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kalyb.mvc.models.Dojo;
import com.kalyb.mvc.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	
	@GetMapping(value="/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping(value="/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojo/new";
		}
	}
	
	@GetMapping(value="/dojos/{id}")
	public String dojoDetails(Model model, @PathVariable("id") Long id) {
		Optional<Dojo> dojo = dojoService.getOne(id);
		model.addAttribute("dojo", dojo.get());
		return "dojoDetails.jsp";
	}
}
