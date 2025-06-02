package com.spring.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.Dto.RequestProduct;
import com.spring.Dto.ResponseProduct;
import com.spring.Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@Tag(name = "PRODUCT-API", description = "All APIS are Related to PRODUCT")
public class ProductController {
	
	
		@Autowired
		private ProductService pro;

		
		@Operation(summary = "Get ALL products", description = "Get All Products Using pagination with page and size parameters")
		@GetMapping("/product")
		public ResponseEntity<List<ResponseProduct>> getAllProduct(
		        @RequestParam int page,
		        @RequestParam(defaultValue = "1") int size) {

		    List<ResponseProduct> rp = pro.getAllProductsOnly(page, size);

		    return new ResponseEntity<>(rp, HttpStatus.OK);
		}
		
		
		
		
		//Post Method
		@Operation(summary = "Add product", description = "Add Products with Category Details")
		@PostMapping("/product")
		public ResponseEntity<?> addproduct(@Valid @RequestBody RequestProduct requestproduct) {
			log.info("product Details :: " + requestproduct);
			
		
				
			

			ResponseProduct rp = pro.addProduct(requestproduct);

			System.out.println(rp);

			return new ResponseEntity(rp, HttpStatus.OK);
			
			
			}
		
		
		

		//Get Method
		@Operation(summary = "Get product", description = "Get Single Product Using ID")
		@GetMapping("/product/{id}")
		public ResponseEntity<?> getProduct(@PathVariable("id") long id) {

			ResponseProduct rp = pro.getOneProduct(id);

			System.out.println(rp);

			return new ResponseEntity(rp, HttpStatus.OK);
		}
		
		
		
		
		
		

		//delete
		@Operation(summary = "Delete product", description = "Delete Single Product Using ID")
		@DeleteMapping("/product/delete/{id}")
		public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {

			String result = pro.deleteProductOneService(id);

			return new ResponseEntity(result, HttpStatus.OK);
		}

		
		
		
		
		//update
		@Operation(summary = "Update product", description = "Update Single Product")
		@PutMapping("/product/{id}")
		public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody RequestProduct requestproduct) {
			log.info("product Details :: " + requestproduct);

			ResponseProduct rp = pro.updateProductOneService(id, requestproduct);

			System.out.println(rp);

			return new ResponseEntity(rp, HttpStatus.OK);
		}

		

}
