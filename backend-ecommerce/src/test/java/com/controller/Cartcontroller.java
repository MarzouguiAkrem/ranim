package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.model.Cart;
import com.example.ecommercebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        cart.setId(id);
        Cart updatedCart = cartService.updateCart(cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
