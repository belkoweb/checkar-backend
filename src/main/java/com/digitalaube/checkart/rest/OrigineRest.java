package com.digitalaube.checkart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalaube.checkart.bean.Origine;
import com.digitalaube.checkart.service.OrigineService;


public class OrigineRest {
	@Autowired
	private OrigineService origineService;
	@DeleteMapping("/api/user/id/{id}")
	public void delete(@PathVariable Long id) {
		origineService.delete(id);
	}
	@PutMapping("/api/user/num/{id}")
	public Origine update(@PathVariable Long id,@RequestBody Origine client) {
		return origineService.save(client);
	}
	@PostMapping("/api/user/")
	public Origine save(@RequestBody Origine client) {
		return origineService.save(client);
	}
	@GetMapping("/api/user/nom/{nom}")
	public Origine findByNom(@PathVariable String nom) {
		return origineService.findByNom(nom);
	}

	@GetMapping("/api/user/id/{id}")
	public Origine findById(@PathVariable Long id) {
	    return origineService.findById(id);
	}
}
