package com.financeiro.personalfinancials.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.personalfinancials.model.GenericJson;
import com.financeiro.personalfinancials.model.Person;
import com.financeiro.personalfinancials.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@PostMapping("create-person")
	private ResponseEntity<?> createPerson(@Valid final Person person) {
		return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
	}

	@GetMapping("find-person-by-id")
	private ResponseEntity<?> findPersonById(final Integer id) {
		final Optional<Person> person = personRepository.findById(id);

		if (person.isPresent()) {
			return new ResponseEntity<>(person.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Id não encontrado"), HttpStatus.OK);
	}

	@GetMapping("find-person-by-name")
	private ResponseEntity<?> findPersonByName(final String name) {
		final List<Person> people = personRepository.findByNameIgnoreCaseContaining(name);

		if (people.size() > 0) {
			return new ResponseEntity<>(people, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Nome não encontrado"), HttpStatus.OK);
	}

	@GetMapping("find-all-people")
	private ResponseEntity<?> findAllPeople() {
		return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
	}

	@PutMapping("update-person-by-id")
	private ResponseEntity<?> updatePersonById(final Person person) {
		if (personRepository.existsById(person.getId())) {
			personRepository.save(person);
			return new ResponseEntity<>(new GenericJson("Pessoa atualizada"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@DeleteMapping("delete-person-by-id")
	private ResponseEntity<?> deletePersonById(final Person person) {
		personRepository.delete(person);
		return new ResponseEntity<>(new GenericJson("Pessoa deletada"), HttpStatus.OK);
	}

}
