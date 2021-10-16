package com.kalyb.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyb.mvc.models.Dojo;
import com.kalyb.mvc.repos.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;

    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    public List<Dojo> getAll() {
    	return dojoRepository.findAll();
    }
    
    public Optional<Dojo> getOne(Long id) {
    	return dojoRepository.findById(id);
    }
    
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
}
