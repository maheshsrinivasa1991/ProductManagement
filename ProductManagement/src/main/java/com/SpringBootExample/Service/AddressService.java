package com.SpringBootExample.Service;



import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBootExample.Entity.Address;
import com.SpringBootExample.Entity.User;
import com.SpringBootExample.Repository.AdderssRepository;

public class AddressService {

	@Autowired
	private AdderssRepository addressrepository;
	public Address saveAddresst(Address address) {
	
		return addressrepository.save(address);
	}
	public void remove(Long id) {
		addressrepository.deleteById(id);
	}

}