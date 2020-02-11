package com.financeiro.personalfinancials.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.personalfinancials.model.UserDTO;
import com.financeiro.personalfinancials.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("create-user")
	private ResponseEntity<?> createUser(@Valid final UserDTO userDTO) {
		return new ResponseEntity<>(userRepository.save(userDTO.UserDTOToUser()).UserToUserAnswerDTO(), HttpStatus.OK);
	}
}
