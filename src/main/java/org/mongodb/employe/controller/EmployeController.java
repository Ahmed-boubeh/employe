package org.mongodb.employe.controller;



import java.util.List;
import java.util.Optional;

import org.mongodb.employe.model.Employe;
import org.mongodb.employe.repository.EmployeRepository;
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
public class EmployeController {

	@Autowired
	private EmployeRepository employeRepository;
	
	@PostMapping("/addEmploye")
	public String saveEmploye(@RequestBody Employe employe) {
	    employeRepository.save(employe);
	    return "added employe whith id :" + employe.getId();
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> EditEmploye(@PathVariable int id ,@RequestBody Employe employe) {
		Optional<Employe> emp = employeRepository.findById(id);
		if (!emp.isPresent())
			return ResponseEntity.notFound().build();
		
		employe.setId(id);
		
		employeRepository.save(employe);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findAllEmploye")
	public List<Employe> getEmploye(){
		return employeRepository.findAll();
	}
	
	@GetMapping("/findAllEmploye/{id}")
	public Optional<Employe> getEmploye(@PathVariable int id){
		return employeRepository.findById(id);
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public String deleteEmploye(@PathVariable int id) {
		employeRepository.deleteById(id);
		return "supprimer avec succes";
	}
	
}
