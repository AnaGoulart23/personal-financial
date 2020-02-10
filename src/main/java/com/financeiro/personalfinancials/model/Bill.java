package com.financeiro.personalfinancials.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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

	@NotNull(message = "O campo tipo é obrigatório.")
	@Column(name = "type")
	private Integer type;

	@NotNull(message = "O campo quantia é obrigatório.")
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "description")
	private String description;

	@NotNull(message = "O campo categoria é obrigatório.")
	@Column(name = "category")
	private Integer category;

	@NotNull(message = "O campo data de criação é obrigatório.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "createdDate")
	private Date createdDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "payDate")
	private Date payDate;

	@Column(name = "currentParcel")
	private Integer currentParcel;

	@Column(name = "totalParcels")
	private Integer totalParcels;

	@NotNull(message = "O campo método de pagamento é obrigatório.")
	@Column(name = "paymentMethod")
	private PaymentMethod paymentMethod;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(final Date payDate) {
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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", personAgainst=" + personAgainst + ", type=" + type + ", amount=" + amount
				+ ", description=" + description + ", category=" + category + ", createdDate=" + createdDate
				+ ", payDate=" + payDate + ", currentParcel=" + currentParcel + ", totalParcels=" + totalParcels
				+ ", paymentType=" + paymentMethod + "]";
	}

}
