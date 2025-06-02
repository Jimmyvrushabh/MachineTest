package com.spring.Model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Slf4j
public class ProductModel {
	
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long pid;
	    private String pname;
	    private String pdescription;
	    private String brand;
	    private BigDecimal price;
	    private Date releaseDate;
	  
	    private int stockQuantity;
	    
	    
	    @CreationTimestamp
		@Column(name = "createdDate", updatable = false)
		private Instant createdTime;

		@CreationTimestamp
		@Column(name = "updatedTime", updatable = true)
		private Instant updatedTime;
	    
	    @ManyToOne(cascade = CascadeType.REMOVE)
		@JoinColumn(name = "categoryID")
		@JsonBackReference
		private CategoryModel category;
	    
	 
	}
	   

	    
	    
	  

