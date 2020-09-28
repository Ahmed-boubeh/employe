package org.mongodb.employe.controller;



import java.util.List;
import java.util.Optional;

import org.mongodb.employe.model.Societe;
import org.mongodb.employe.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocieteController {

	@Autowired
	private SocieteRepository societeRepository;
	
	@PostMapping("/addSociete")
	public String saveSociete(@RequestBody Societe societe) {
	    societeRepository.save(societe);
	    return "added Societe whith id :" + societe.getId();
	}
	
	@PutMapping("/editsociete/{id}")
	public ResponseEntity<Object> EditSociete(@PathVariable int id ,@RequestBody Societe societe) {
		Optional<Societe> emp = societeRepository.findById(id);
		if (!emp.isPresent())
			return ResponseEntity.notFound().build();
		
		societe.setId(id);
		
		societeRepository.save(societe);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findAllSociete")
	public List<Societe> getSociete(){
		return societeRepository.findAll();
	}
	
	@GetMapping("/findAllSociete/{id}")
	public Optional<Societe> getSociete(@PathVariable int id){
		return societeRepository.findById(id);
	}
	
	@DeleteMapping("/deleteSociete/{id}")
	public String deleteSociete(@PathVariable int id) {
		societeRepository.deleteById(id);
		return "supprimer avec succes";
	}
	
}
