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
@Table(name = "Category")
@SequenceGenerator(name = "seq_category", sequenceName = "sequence_category", initialValue = 1, allocationSize = 1)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@NotBlank(message = "O nome da categoria é obrigatório.")
	@Size(max = 30, message = "O tamanho precisa ser de no máximo 30 caracteres.")
	private String name;

	public Category() {

	}

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

}
