package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Dto.RequestCategory;
import com.spring.Model.CategoryModel;
import com.spring.Repo.CategoryRepo;
import com.spring.Service.CategoryService;


import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@Tag(name = "CATEGORIES-API", description = "All APIS are Related to CATEGORIES")
public class CategoryController {
	
	

	
		@Autowired
		private CategoryService cat;
		
		@Autowired
		private CategoryRepo cam;
		
		
		@RequestMapping
		public String hello() {
			return "hello";
		}
		
	
		  
		  
		  

		@Operation(summary = "Add Categopry", description = "Add Category Details")
		@PostMapping("/categories")
		public ResponseEntity<?> Addcategories(@RequestBody RequestCategory requestCategory) {

			log.info("Add Category :: " + requestCategory);

			return new ResponseEntity(cat.registerCategoryonly(requestCategory), HttpStatus.OK);
		}

		
		
		
		
		
		
		@Operation(summary = "GetAll Categories", description = "Get All Categories Using pagination page and Size")
		@GetMapping("/categories")
		public ResponseEntity<?> getAllCategories(@RequestParam("page") int page, @RequestParam(defaultValue = "5") int size) {

			return new ResponseEntity(cat.getAllCategoryOnly(page, size), HttpStatus.OK);
		}

		@Operation(summary = "get Category", description = "Get Single Category with there Respsective")
		@GetMapping("/categories/{id}")
		public ResponseEntity<?> getSingleCategory(@PathVariable("id") int id) {

			return new ResponseEntity(cat.getSingleCateogryOnly(id), HttpStatus.OK);
		}

		@Operation(summary = "Update Category", description = "Update Category Details")
		@PutMapping("/categories/{id}")
		public ResponseEntity<?> updateCategory(@PathVariable("id") int id, @RequestBody RequestCategory requestCategory) {

			return new ResponseEntity(cat.updateCategoryonly(id, requestCategory), HttpStatus.OK);
		}

		@Operation(summary = "Delete Category", description = "Delete Category Details")
		@DeleteMapping("/categories/delete/{id}")
		public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {

			return new ResponseEntity(cat.deleteCategoryWithId(id), HttpStatus.OK);
		}
	
	

}
