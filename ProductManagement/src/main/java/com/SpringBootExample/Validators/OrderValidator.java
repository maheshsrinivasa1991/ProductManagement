package com.SpringBootExample.Validators;



import javax.persistence.OrderBy;
import javax.persistence.criteria.Order;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.SpringBootExample.Entity.Product;

public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");

        OrderBy order = (OrderBy) o;

        if( ((Product) order).getProductname().length() < 2 ){
            errors.rejectValue("name", "name.required");
        }

        if(((Product) order).getorders()==null || ((Product) ((Product) order).getorders()).size() < 1){
            errors.rejectValue("product", "product.required");
        }
    }
}