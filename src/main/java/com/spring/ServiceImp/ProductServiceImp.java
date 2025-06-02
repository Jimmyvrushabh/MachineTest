package com.spring.ServiceImp;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.Dto.RequestProduct;
import com.spring.Dto.ResponseProduct;
import com.spring.ExceptionHandling.CategoryNotFound;
import com.spring.ExceptionHandling.ProductNotFound;
import com.spring.Model.CategoryModel;
import com.spring.Model.ProductModel;
import com.spring.Repo.CategoryRepo;
import com.spring.Repo.Productrepo;
import com.spring.Service.ProductService;

@Service
public class ProductServiceImp  implements ProductService {

	@Autowired
	private Productrepo pr;

	@Autowired
	private CategoryRepo cr;

	
	
	
	@Override
	public ResponseProduct addProduct(RequestProduct requestproduct) {
		

		System.out.println(requestproduct);
		
//		if (requestproduct.getCategoryName() == null) {
//		    throw new IllegalArgumentException("Category name must not be null");
//		}

		CategoryModel categ = cr.findByCategoryName(requestproduct.getCategoryName().toUpperCase())
				.orElseThrow(() -> new CategoryNotFound("Category is not found with this given Name"));

		if (pr.existsById(requestproduct.getPid())){
			throw new ProductNotFound("Product Not Found Exception");
		}

//		Product product = pr.findById(requestproduct.getProductID()).get();

		ProductModel product = new ProductModel();

		
		product.setCategory(categ);
		product.setPdescription(requestproduct.getPdescription());
		product.setPname(requestproduct.getPname());
		product.setBrand(requestproduct.getBrand());
		product.setPrice(requestproduct.getPrice());
		product.setStockQuantity(requestproduct.getStockQuantity());
		product.setReleaseDate(requestproduct.getReleaseDate());
	
		

		ProductModel prod = pr.save(product);

		System.out.println(prod);

		ModelMapper model = new ModelMapper();

		ResponseProduct rp = model.map(prod, ResponseProduct.class);

		System.out.println(rp);

		return rp;
	}

	@Override
	public ResponseProduct getOneProduct(long id) {
		ProductModel product = pr.findById(id)
				.orElseThrow(() -> new ProductNotFound("Product Not Found With This ID"));

		ModelMapper model = new ModelMapper();

		ResponseProduct rp = model.map(product, ResponseProduct.class);

		return rp;
	}

	@Override
	public String deleteProductOneService(long id) {
		
		ProductModel product = pr.findById(id)
				.orElseThrow(() -> new ProductNotFound("Product Not Found With This ID"));

		product.setCategory(null);
		pr.delete(product);

		return "Product Deleted";
	}
	

	@Override
	public ResponseProduct updateProductOneService(long id, RequestProduct requestproduct) {
		

		ModelMapper model = new ModelMapper();
		ProductModel product = pr.findById(id)
				.orElseThrow(() -> new ProductNotFound("Product Not Found With This ID"));

		product.setPname(requestproduct.getPname());
		product.setPdescription(requestproduct.getPdescription());

		CategoryModel categ = cr.findByCategoryName(requestproduct.getCategoryName().toUpperCase())
				.orElseThrow(() -> new CategoryNotFound("Category is not found with this given Name"));

		product.setCategory(categ);

		ProductModel prod = pr.save(product);

		ResponseProduct rp = model.map(prod, ResponseProduct.class);

		return rp;
	}

	@Override
	public List<ResponseProduct> getAllProductsOnly(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size); // Optional sorting
	    List<ProductModel> listOfProduct = pr.findAll(pageable).getContent();

	    ModelMapper map = new ModelMapper();
	    return listOfProduct.stream()
	            .map(product -> map.map(product, ResponseProduct.class))
	            .collect(Collectors.toList());
	}

	}

	

