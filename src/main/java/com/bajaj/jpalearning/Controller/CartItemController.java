package com.bajaj.jpalearning.Controller;

import com.bajaj.jpalearning.Services.CartItemService;
import com.bajaj.jpalearning.Services.ProductService;
import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.entities.CartItem;
import com.bajaj.jpalearning.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCartProducts(@PathVariable Long id) {
        List<Product> listOfProducts = cartItemService.getCustomerCart(id);
        return ResponseHandler.createResponse("Added to cart", HttpStatus.OK, listOfProducts);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCartItem(@RequestBody CartItem cartItem) {
        Object cartedCartItem = cartItemService.createCartItem(cartItem);
        return ResponseHandler.createResponse("Added to cart", HttpStatus.CREATED, cartedCartItem);
    }


}
