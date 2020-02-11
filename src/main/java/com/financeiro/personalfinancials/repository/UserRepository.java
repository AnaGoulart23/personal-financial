package com.financeiro.personalfinancials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.personalfinancials.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

	public Boolean existsByUsername(String username);

	public User findByEmail(String email);

	public Boolean existsByEmail(String email);

}
