package com.exilant.training.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.training.model.Person;
import com.exilant.training.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository repository;

	@PostMapping("/addPerson")
	public String savePerson(@RequestBody Person person) {
		repository.save(person);
     return "Person added with id:"+person.getId();
	}
	
	@GetMapping("/findAllPersons")
	public List<Person> getPersons(){
		return repository.findAll();
	}
	
	@GetMapping("/findPerson/{id}")
	public Optional<Person> getPerson(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public String deletePerson(@PathVariable int id) {
		repository.deleteById(id);
		return "Person Deleted with id:"+id;
	}
}
