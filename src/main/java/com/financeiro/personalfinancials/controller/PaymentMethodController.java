package com.financeiro.personalfinancials.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.personalfinancials.model.GenericJson;
import com.financeiro.personalfinancials.model.PaymentMethod;
import com.financeiro.personalfinancials.repository.PaymentMethodRepository;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@PostMapping("create-payment-method")
	private ResponseEntity<?> createPaymentMethod(@Valid final PaymentMethod genericPaymentMethod) {
		return new ResponseEntity<>(paymentMethodRepository.save(genericPaymentMethod), HttpStatus.OK);
	}

	@GetMapping("find-all-payment-methods")
	private ResponseEntity<?> findAllPaymentMethods() {
		return new ResponseEntity<>(paymentMethodRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("find-payment-method-by-id")
	private ResponseEntity<?> findPaymentMethodById(final Integer id) {
		final Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
		if (paymentMethod.isPresent()) {
			return new ResponseEntity<>(paymentMethod.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Método de pagamento não encontrado"), HttpStatus.OK);
	}

}
