package com.SpringBootExample.Validators;

	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

import com.SpringBootExample.Entity.Product;

	public class AddressValidator implements Validator{

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Product.class.equals(aClass);
	    }

	    @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "name.required");

	        Product group = (Product) o;

	        if( group.getProductname().length() < 2 ){
	            errors.rejectValue("productName", "name.required");
	        }
	    }
	}