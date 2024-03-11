package com.bajaj.jpalearning.Services;

import com.bajaj.jpalearning.entities.CartItem;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Product;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.CartItemRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

//    public List<CartItem> getCustomerCart(Long customer_id) {
//
//        Optional<Customer> customerOptional = customerRepository.findById(customer_id);
//        if(customerOptional.isPresent()) {
//            List<CartItem> cartItems = cartItemRepository.findByCustomer(customerOptional.get());
//        }
//
//        return cartItems;
//    }

    public List<Product> getCustomerCart(Long customer_id) {

        Optional<Customer> customerOptional = customerRepository.findById(customer_id);
        if (customerOptional.isPresent()) {
            List<CartItem> cartItems = cartItemRepository.findByCustomer(customerOptional.get());

            if (cartItems.size() > 0) {
                List<Product> products = cartItems.stream().map((cartItem -> cartItem.getProduct())).toList();
                return products;
            }

        }
        throw new EntityNotFoundException("Customer Does not exist");
    }

    public CartItem getCartItemsById(Long id) {
        Optional<CartItem> cartItem = cartItemRepository.findById(id);
        if (cartItem.isPresent()) {
            return cartItem.get();
        }
        throw new EntityNotFoundException("Cart item with given ID is not present");
    }

    public CartItem createCartItem(CartItem cartItem) {
        Optional<Product> productOptional = productRepository.findById(cartItem.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findById(cartItem.getCustomer().getId());

        if (productOptional.isPresent() && customerOptional.isPresent() && (cartItem.getQuantity() > 0)) {
            return cartItemRepository.save(cartItem);
        }

        throw new EntityNotFoundException("Product & Customer not exist");
    }


}
