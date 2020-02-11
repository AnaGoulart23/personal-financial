package com.financeiro.personalfinancials.model;

public class UserAnswerDTO {

	private Integer id;

	private String username;

	private String email;

	public UserAnswerDTO(final Integer id, final String username, final String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
