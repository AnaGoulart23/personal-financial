package com.financeiro.personalfinancials.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

	@Size(min = 3, max = 20, message = "O tamanho da senha deve estar entre 6 e 15 caracteres.")
	@NotBlank(message = "O usuário é obrigatório.")
	private String username;

	@Size(min = 10, max = 40, message = "O tamanho da senha deve estar entre 6 e 15 caracteres.")
	@NotBlank(message = "O e-mail é obrigatório.")
	private String email;

	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 6, max = 15, message = "O tamanho da senha deve estar entre 6 e 15 caracteres.")
	private String password;

	public UserDTO(final String username, final String email, final String password) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public User UserDTOToUser() {
		return new User(getUsername(), getPassword(), getEmail());
	}

}
