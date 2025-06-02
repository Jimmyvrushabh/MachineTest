package com.spring.Dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseProduct {

	private Long pid;
    private String pname;
    private String pdescription;
    private String brand;
    private BigDecimal price;
    private Date releaseDate;
    private int stockQuantity;

    private Instant createdTime;
    private Instant updatedTime;

    private Long categoryId;
    private String categoryName;
	
}