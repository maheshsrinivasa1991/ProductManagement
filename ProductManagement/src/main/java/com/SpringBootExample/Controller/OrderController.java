package com.SpringBootExample.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Resource.OrderResource;
import com.SpringBootExample.Service.OrderService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

@RestController
@RequestMapping("/order")
public class OrderController extends ProductController {

    @Autowired
    private OrderService orderService;

    @Autowired
    Validator orderValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(orderValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderResource> index() {
        List<Order> orders = orderService.getOrder();
        List<OrderResource> out = new ArrayList<OrderResource>();
        if(orders != null){
            orders.forEach(o -> {
                OrderResource orderResource = new OrderResource();
                orderResource.add(createHateoasLink(((OrderResource) o).getUserId()));

                out.add(orderResource);
            });
        }
        return out;
    }

    private Object createHateoasLink(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping
    public Order create(@RequestBody @Validated Order order){

        // Required by Hibernate ORM to save properly
        if(((OrderResource) order).getOrderId() !=null){
            ((OrderService) order).getOrder().forEach(product -> ((Product) product).setOrder(order));
        }
        return OrderService.addOrder(order);
    }

    @RequestMapping("/{Userid}")
    public OrderResource view(@PathVariable("id") long id){
        OrderResource orderResource = new OrderResource(orderService.getOrder(id));
        orderResource.add(createHateoasLink(id));
        return orderResource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Order edit(@PathVariable("id") long id, @RequestBody @Validated Order order){

        Order updatedOrder = orderService.getOrder(id);

        if(updatedOrder== null){
            return null;
        }


        return OrderService.addOrder(updatedOrder);
    }
}
