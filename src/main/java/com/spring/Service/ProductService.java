package com.spring.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.Dto.RequestProduct;
import com.spring.Dto.ResponseProduct;

public interface ProductService {
	
	
	ResponseProduct addProduct(RequestProduct requestproduct);

	ResponseProduct getOneProduct(long id);

	String deleteProductOneService(long id);

	ResponseProduct updateProductOneService(long id, RequestProduct requestproduct);

	List<ResponseProduct> getAllProductsOnly(int page, int size);

}



