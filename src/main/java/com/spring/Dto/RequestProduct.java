package com.spring.Dto;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestProduct {
	
	
	
	private long pid;
	
	 @NotBlank(message = "Product name is required")
	    private String pname;

	    private String pdescription;

	    private String brand;

	    @NotNull(message = "Price is required")
	    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
	    private BigDecimal price;

	    @PastOrPresent(message = "Release date can't be in the future")
	    private  Date releaseDate;

	    @Min(value = 0, message = "Stock quantity can't be negative")
	    private int stockQuantity;

	  
	    @NotBlank(message = "cannot be blank")
	    private String categoryName;
	    
	   
}
