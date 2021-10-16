package com.kalyb.mvc.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kalyb.mvc.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
