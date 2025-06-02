package com.spring.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Model.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Long> {

	boolean existsByCategoryName(String cname);

	Optional<CategoryModel> findByCategoryName(String cname);
 

}
