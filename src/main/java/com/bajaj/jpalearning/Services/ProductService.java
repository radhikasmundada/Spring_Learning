package com.bajaj.jpalearning.Services;

import com.bajaj.jpalearning.entities.Product;
import com.bajaj.jpalearning.exceptions.EntityIsAlreadyExistException;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new EntityNotFoundException("Product with given ID is not present");
    }

    public Product createProduct(Product product) {
//        if (productRepository.findById(product.getId()).isEmpty()) {
            Product newProducts = productRepository.save(product);

//            newProducts.setId(product.getId());
//            newProducts.setName(product.getName());
//            newProducts.setImageUrl(product.getImageUrl());
//            newProducts.setPrice(product.getPrice());

            return newProducts;
        //}
//        throw new EntityIsAlreadyExistException("This product is already exist");
    }








//    public void deleteProductById(Long id) {
//        Optional<Product> product = productRepository.findById(id);
//        if (customer.isPresent()) {
//            customerRepository.deleteById(id);
//        } else {
//            throw new CustomerNotFoundException("Customer with given ID is not present");
//        }
//    }

//    public Customer updateCustomer(Long id, Customer customer) {
//        if (customerRepository.findById(id).isPresent()) {
//
//            customer.setPassword(customer.getPassword());
//            customer.setAddresses(customer.getAddresses());
//
//            Customer updatedCustomer = customerRepository.save(customer);
//            return updatedCustomer;
//        }
//        throw new CustomerNotFoundException("Customer with given ID is not present");
//    }
}
