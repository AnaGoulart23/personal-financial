package com.financeiro.personalfinancials.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("2")
public class CreditCard extends PaymentMethod {

	private static final long serialVersionUID = 1L;

	@Column(name = "brand")
	@Size(min = 4, max = 15)
	private String brand;

	@Column(name = "number")
	@Size(min = 16, max = 16)
	private String number;

	public CreditCard() {
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

}
