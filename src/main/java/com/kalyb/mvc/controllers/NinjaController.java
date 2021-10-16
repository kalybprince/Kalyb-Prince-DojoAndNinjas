package com.kalyb.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kalyb.mvc.models.Ninja;
import com.kalyb.mvc.services.DojoService;
import com.kalyb.mvc.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	@GetMapping(value="/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "newNinja.jsp";
	}
	
	@PostMapping(value="/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAll());
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninja/new";
		}
	}
}
