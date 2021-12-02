package com.SpringBootExample.Repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootExample.Entity.Address;
import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Entity.User;


@Repository
public interface AdderssRepository extends JpaRepository<Address,Long>{

		Address save(Address address);

		void deleteById(int existingAddress);

		void deleteById(Address existingAddress);

	}	


