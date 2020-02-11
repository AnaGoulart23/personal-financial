package com.financeiro.personalfinancials.model;

import java.io.Serializable;

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
@Table(name = "PaymentMethod")
@SequenceGenerator(name = "seq_payment_method", sequenceName = "sequence_payment_method", initialValue = 1, allocationSize = 1)
public class PaymentMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_method")
	private Integer id;

	@NotBlank
	@Column(name = "name")
	@Size(min = 5, max = 30, message = "O tamanho deve ser entre 5 e 30 caracteres.")
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

}
