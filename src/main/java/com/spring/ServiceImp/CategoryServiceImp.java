package com.spring.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.Dto.RequestCategory;
import com.spring.Dto.ResponseCategory;
import com.spring.ExceptionHandling.CategoryNotFound;
import com.spring.Model.CategoryModel;
import com.spring.Repo.CategoryRepo;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CategoryServiceImp implements com.spring.Service.CategoryService {

	
	@Autowired
	private CategoryRepo car;
	
	
	@Override
	 public CategoryModel addCategory(CategoryModel categoryModel) {
        if (car.existsByCategoryName(categoryModel.getCategoryName())) {
            throw new RuntimeException("Category already exists with name: " + categoryModel.getCategoryName());
        }
        return car.save(categoryModel);
    }


		
	

	@Override
	public List<ResponseCategory> getAllCategoryOnly(int page, int size) {
		PageRequest p = PageRequest.of(page, size);

		List<CategoryModel> list = car.findAll(p).getContent();

		ModelMapper model1 = new ModelMapper();

		List<ResponseCategory> lresponse = list.stream().map(n -> model1.map(n, ResponseCategory.class))
				.collect(Collectors.toList());

		return lresponse;
	}

	@Override
	public ResponseCategory getSingleCateogryOnly(long id) {
		
		CategoryModel categ = car.findById(id)
				.orElseThrow(() -> new CategoryNotFound("Category is not found with this given ID"));
		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(categ, ResponseCategory.class);
		return responseCategory;
	}

	@Override
	public ResponseCategory updateCategoryonly(long id, RequestCategory requestCategory) {
		CategoryModel categ = car.findById(id)
				.orElseThrow(() -> new CategoryNotFound("Category is not found with this given ID"));

		categ.setCategoryName(requestCategory.getCategoryName());

		CategoryModel categ2 = car.save(categ);

		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(categ2, ResponseCategory.class);
		return responseCategory;
	}

	@Override
	public String deleteCategoryWithId(long id) {
		
		CategoryModel categ = car.findById(id)
				.orElseThrow(() -> new CategoryNotFound("Category is not found with this given ID"));

		car.delete(categ);

		return "Category Deleted";
	}





	@Override
	public ResponseCategory registerCategoryonly(RequestCategory requestCategory) {
		
		log.info("Categories ::" + requestCategory);

		if (car.existsByCategoryName(requestCategory.getCategoryName())) {

			System.out.println("already Exist");
//			 throw new CategoryAlreadyExist("Category Alredy Present");
		}

		CategoryModel categ = new CategoryModel();

		ModelMapper model1 = new ModelMapper();
		CategoryModel catg1 = model1.map(requestCategory, CategoryModel.class);

		CategoryModel category2 = car.save(catg1);

		System.out.println(category2);

		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(category2, ResponseCategory.class);

	log.info("RepsonseCategory : " + responseCategory);

		return responseCategory;
	}
	
	

}
