package com.SpringBootExample.Controller;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.SpringBootExample.Entity.Address;
import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Entity.User;
	import com.SpringBootExample.Repository.AdderssRepository;
import com.SpringBootExample.Repository.ProductRepository;
import com.SpringBootExample.Service.ProductService;
import com.SpringBootExample.Service.UserService;
	import com.SpringBootExample.exception.ResourceNotFoundException;

	import lombok.Data;

	@Data
	@RestController
	@RequestMapping("/Product")
	public class ProductController {
		
		@Autowired
		private ProductService productservice;
		@Autowired
		private ProductRepository productRepository;
		private CrudRepository<Product, Long> productRepository1;
		
		
		@PostMapping("/add")
		public Product addProduct(@RequestBody Product product)
		{
			return productservice.saveProduct(product);
		}
		
		
		@GetMapping("/{id}")
		public Product updateProduct(@RequestBody Product product, @PathVariable ("id") long productId) throws ResourceNotFoundException {
			 
			Product existingProduct = ((CrudRepository<Product,Long>) this.productRepository1).findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("Address not found with id :" + productId));



				existingProduct.setProductname(product.getProductname());
				existingProduct.setProductSKU(product.getProductSKU());
				existingProduct.setPrice(product.getPrice());
				existingProduct.setIsActive(product.getIsActive());
				existingProduct.setQty(product.getQty());
				existingProduct.setCreatedAt(product.getCreatedAt());
				existingProduct.setCreatedBy(product.getCreatedBy());
				existingProduct.setModifiedAt(product.getModifiedAt());
				existingProduct.setModifiedBy(product.getModifiedBy());
		
			 return this.productRepository.save(existingProduct);
		}
		
		
		public void remove(Long id){
			productRepository.deleteById(id);
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<User> deleteUser(@PathVariable ("id") long productId) throws ResourceNotFoundException{
			 Product existingProduct = this.productRepository.findById(productId)
						.orElseThrow(() -> new ResourceNotFoundException("product not found with id :" + productId));
			this.productRepository.delete(existingProduct);
			 return ResponseEntity.ok().build();
		}
	}
