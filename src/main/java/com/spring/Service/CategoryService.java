package com.spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Dto.RequestCategory;
import com.spring.Dto.ResponseCategory;
import com.spring.Model.CategoryModel;


public interface CategoryService {
	
	
	ResponseCategory registerCategoryonly(RequestCategory requestCategory);

	List<ResponseCategory> getAllCategoryOnly(int page, int size);

	ResponseCategory getSingleCateogryOnly(long id);

	ResponseCategory updateCategoryonly(long id, RequestCategory requestCategory);

	String deleteCategoryWithId(long id);

	CategoryModel addCategory(CategoryModel categoryModel);


}
