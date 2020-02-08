package com.financeiro.personalfinancials.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.personalfinancials.model.Bill;
import com.financeiro.personalfinancials.model.Category;
import com.financeiro.personalfinancials.model.PaymentMethod;
import com.financeiro.personalfinancials.model.Person;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

	public List<Bill> findByPersonAgainst(Person personAgainst);

	public List<Bill> findByCategory(Category category);

	public List<Bill> findByCreatedDate(java.sql.Date createdDate);

	public List<Bill> findByPayDate(java.sql.Date payDate);

	public List<Bill> findByPaymentMethod(PaymentMethod paymentMethod);

}
