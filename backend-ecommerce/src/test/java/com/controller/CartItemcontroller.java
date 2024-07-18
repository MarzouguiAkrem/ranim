package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.model.CartItem;
import com.example.ecommercebackend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.createCartItem(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
        cartItem.setId(id);
        CartItem updatedCartItem = cartItemService.updateCartItem(cartItem);
        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
