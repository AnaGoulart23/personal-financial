package com.financeiro.personalfinancials.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.personalfinancials.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	public List<Person> findByNameIgnoreCaseContaining(String name);

}
