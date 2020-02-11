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

import com.financeiro.personalfinancials.model.Category;
import com.financeiro.personalfinancials.model.GenericJson;
import com.financeiro.personalfinancials.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("create-category")
	private ResponseEntity<?> createCategory(@Valid final Category category) {
		return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
	}

	@GetMapping("find-category-by-id")
	private ResponseEntity<?> findCategoryById(final Integer id) {
		final Optional<Category> category = categoryRepository.findById(id);

		if (category.isPresent()) {
			return new ResponseEntity<>(category.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Id não encontrado"), HttpStatus.OK);
	}

	@GetMapping("find-category-by-name")
	private ResponseEntity<?> findCategoryByName(final String name) {
		final List<Category> categories = categoryRepository.findByNameIgnoreCaseContaining(name);

		if (categories.size() > 0) {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Nome não encontrado"), HttpStatus.OK);
	}

	@GetMapping("find-all-categories")
	private ResponseEntity<?> findAllCategories() {
		return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
	}

	@PutMapping("update-category-by-id")
	private ResponseEntity<?> updateCategory(final Category category) {
		if (categoryRepository.existsById(category.getId())) {
			categoryRepository.save(category);
			return new ResponseEntity<>(new GenericJson("Categoria atualizada"), HttpStatus.OK);
		}

		return new ResponseEntity<>(new GenericJson("Id não encontrado"), HttpStatus.OK);
	}

	@DeleteMapping("delete-category-by-id")
	private ResponseEntity<?> deleteCategoryById(final Category category) {
		categoryRepository.delete(category);
		return new ResponseEntity<>("Categoria deletada", HttpStatus.OK);
	}

}
