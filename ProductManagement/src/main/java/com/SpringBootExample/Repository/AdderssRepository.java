package com.SpringBootExample.Repository;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootExample.Entity.Address;
import com.SpringBootExample.Entity.Product;


@Repository
public interface AdderssRepository extends JpaRepository<Address,Long>{

		Address save(Product group);

		void deleteById(int existingAddress);

		void deleteById(Address existingAddress);

		Product findOne(long id);

		Address save(Order order);

	}	


