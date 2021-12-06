package com.SpringBootExample.Repository;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootExample.Entity.Address;
import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Resource.ProductResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AdderssRepository addressRepository;

    @Autowired
    AdderssRepository orderRepository;

    @Autowired
    private SessionFactory sessionFactory;


    /* PRODUCT */
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProduct(long id){
        return productRepository.findById(id);
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public String addProductImage(final String productId, final String filename){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ProductResource image = new ProductResource(null);
        image.setProductId(Long.parseLong(productId));
        image.setPath(filename);

        try {
            String res = session.save(image).toString();
            session.getTransaction().commit();
            return res;
        } catch (HibernateException e) {
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return "";
    }

    /* GROUPS */
    public List<Address> getOrder(){
        try {
			return orderRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    public Product getGroup(long id){
        return addressRepository.findOne(id);
    }
    public Object saveGroup(Product order){
        return addressRepository.save(order);
    }

    /* ORDERS */
    public Collection<Address> getOrders(){
        return orderRepository.findAll();
    }
    public Object getOrder(long id){
        return orderRepository.findById(id);
    }
    public Address saveOrder(Order order){
        return orderRepository.save(order);
    }
}
