package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.entities.CartItem;
import com.bajaj.jpalearning.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByCustomer(Customer customer);

}
