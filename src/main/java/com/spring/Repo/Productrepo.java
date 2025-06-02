package com.spring.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Model.ProductModel;

@Repository
public interface  Productrepo  extends JpaRepository<ProductModel, Long>  {
	
	

}
