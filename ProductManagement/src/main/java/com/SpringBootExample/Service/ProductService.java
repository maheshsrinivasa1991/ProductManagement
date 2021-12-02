package com.SpringBootExample.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Repository.ProductRepository;

public class ProductService {

	@Autowired
	private ProductRepository productrepository;
	public Product saveProduct(Product product) {
	
		return productrepository.save(product);
	}

	public void remove(Long id) {
		productrepository.deleteById(id);
	}
	public static List<Product>getAllProducts(){
		List<Product>allStudent =new ArrayList<Product>();
		return allStudent;
		}
}
