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
import com.SpringBootExample.Entity.User;
import com.SpringBootExample.Repository.AdderssRepository;
import com.SpringBootExample.Service.AddressService;
import com.SpringBootExample.exception.ResourceNotFoundException;

import lombok.Data;

@Data
@RestController
@RequestMapping("/Address")
public class AddressController {

	@Autowired
	private AddressService addressservice;
	@Autowired
	private AdderssRepository addressRepository1;
	private Object addressRepository;


	@PostMapping("/add")
	public Address addAddress(@RequestBody Address address)
	{
		return addressservice.saveAddresst(address);
	}


	@GetMapping("/{id}")
	public Address updateaddress(@RequestBody Address address, @PathVariable ("id") long addressId) throws ResourceNotFoundException {
		  Address existingAddress = ((CrudRepository<Address,Long>) this.addressRepository).findById(addressId)
			.orElseThrow(() -> new ResourceNotFoundException("Address not found with id :" + addressId));



		existingAddress.setAddress1(address.getAddress1());
		existingAddress.setAddress2(address.getAddress2());
		existingAddress.setPincode(address.getPincode());
		existingAddress.setActive(address.getisActive());
		existingAddress.setPrimary(address.getisPrimary());
		existingAddress.setCreatedAt(address.getCreatedAt());
		existingAddress.setCreatedBy(address.getCreatedBy());
		existingAddress.setModifiefdAt(address.getModifiefdAt());
		existingAddress.setModifiedBy(address.getModifiedBy());
		return ((AdderssRepository) this.addressRepository1).save(existingAddress);
	}
	
	


	public void remove(int id){
		 ((AdderssRepository) addressRepository).deleteById(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId) throws ResourceNotFoundException{
		Long address = null;
		Address existingAddress = ((CrudRepository<Address,Long>) this.addressRepository1).findById(address)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found with id :" + address));
		((AdderssRepository) this.addressRepository1).deleteById(existingAddress);
		return ResponseEntity.ok().build();
	}

	

	public Object getAddressRepository() {
		return addressRepository;
	}


	public void setAddressRepository(Object addressRepository) {
		this.addressRepository = addressRepository;
	}
}
