package com.kalyb.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyb.mvc.models.Ninja;
import com.kalyb.mvc.repos.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
