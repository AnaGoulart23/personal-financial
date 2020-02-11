package com.financeiro.personalfinancials.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
@SequenceGenerator(name = "seq_person", sequenceName = "sequence_person", initialValue = 1, allocationSize = 1)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "O campo é obrigatório.")
	@Size(min = 3, max = 100, message = "O tamanho precisa estar entre 3 e 100 caracteres.")
	@Column(name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
