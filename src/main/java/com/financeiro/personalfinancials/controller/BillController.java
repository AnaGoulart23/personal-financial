package com.financeiro.personalfinancials.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.personalfinancials.model.Bill;
import com.financeiro.personalfinancials.model.Category;
import com.financeiro.personalfinancials.model.GenericJson;
import com.financeiro.personalfinancials.model.PaymentMethod;
import com.financeiro.personalfinancials.model.Person;
import com.financeiro.personalfinancials.repository.BillRepository;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	BillRepository billRepository;

	@PostMapping("create-bill")
	private ResponseEntity<?> createBill(@Valid final Bill bill) {
		return new ResponseEntity<>(billRepository.save(bill), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-id")
	private ResponseEntity<?> findBillById(final Integer id) {
		final Optional<Bill> bill = billRepository.findById(id);

		if (bill.isPresent()) {
			return new ResponseEntity<>(bill.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Id não encontrado"), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-person")
	private ResponseEntity<?> findBillByPerson(final Person person) {
		final List<Bill> bill = billRepository.findByPersonAgainst(person);

		if (bill.size() > 0) {
			return new ResponseEntity<>(bill, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-category")
	private ResponseEntity<?> findBillByCategory(final Category category) {
		final List<Bill> bill = billRepository.findByCategory(category);

		if (bill.size() > 0) {
			return new ResponseEntity<>(bill, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-created-date")
	private ResponseEntity<?> findBillByCreatedDate(final java.sql.Date createdDate) {
		final List<Bill> bill = billRepository.findByCreatedDate(createdDate);

		if (bill.size() > 0) {
			return new ResponseEntity<>(bill, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-pay-date")
	private ResponseEntity<?> findBillByPayDate(final java.sql.Date payDate) {
		final List<Bill> bill = billRepository.findByPayDate(payDate);

		if (bill.size() > 0) {
			return new ResponseEntity<>(bill, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@GetMapping("find-bill-by-payment-method")
	private ResponseEntity<?> findBillByPaymentMethod(final PaymentMethod paymentMethod) {
		final List<Bill> bill = billRepository.findByPaymentMethod(paymentMethod);

		if (bill.size() > 0) {
			return new ResponseEntity<>(bill, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Pessoa não encontrada"), HttpStatus.OK);
	}

	@GetMapping("find-all-bills")
	private ResponseEntity<?> findAllBills() {
		return new ResponseEntity<>(billRepository.findAll(), HttpStatus.OK);
	}

	@PutMapping("update-bill")
	private ResponseEntity<?> updateBill(@Valid final Bill bill) {
		if (billRepository.existsById(bill.getId())) {
			billRepository.save(bill);
			return new ResponseEntity<>("Lançamento atualizado", HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Lançamento não encontrado"), HttpStatus.OK);
	}

	@DeleteMapping("delete-bill-by-id")
	private ResponseEntity<?> deleteBill(final Bill bill) {
		billRepository.delete(bill);
		return new ResponseEntity<>(new GenericJson("Lançamento deletado"), HttpStatus.OK);
	}

}
