package com.financeiro.personalfinancials.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
@SequenceGenerator(name = "seq_bill", sequenceName = "sequence_bill", initialValue = 1, allocationSize = 1)
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bill")
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	private Person personAgainst;

	@Column(name = "type")
	private Integer type;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private Integer category;

	@Column(name = "createdDate")
	private java.sql.Date createdDate;

	@Column(name = "payDate")
	private java.sql.Date payDate;

	@Column(name = "currentParcel")
	private Integer currentParcel;

	@Column(name = "totalParcels")
	private Integer totalParcels;

	@Column(name = "paymentType")
	private Integer paymentType;

	public Bill() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Person getPersonAgainst() {
		return personAgainst;
	}

	public void setPersonAgainst(final Person personAgainst) {
		this.personAgainst = personAgainst;
	}

	public Integer getType() {
		return type;
	}

	public void setType(final Integer type) {
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(final Integer category) {
		this.category = category;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.sql.Date getPayDate() {
		return payDate;
	}

	public void setPayDate(final java.sql.Date payDate) {
		this.payDate = payDate;
	}

	public Integer getCurrentParcel() {
		return currentParcel;
	}

	public void setCurrentParcel(final Integer currentParcel) {
		this.currentParcel = currentParcel;
	}

	public Integer getTotalParcels() {
		return totalParcels;
	}

	public void setTotalParcels(final Integer totalParcels) {
		this.totalParcels = totalParcels;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(final Integer paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", personAgainst=" + personAgainst + ", type=" + type + ", amount=" + amount
				+ ", description=" + description + ", category=" + category + ", createdDate=" + createdDate
				+ ", payDate=" + payDate + ", currentParcel=" + currentParcel + ", totalParcels=" + totalParcels
				+ ", paymentType=" + paymentType + "]";
	}

}
