package com.SpringBootExample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Entity.User;

@Repository
	public interface ProductRepository extends JpaRepository<Product,Long>{

			Product save(Product product);

		}	


