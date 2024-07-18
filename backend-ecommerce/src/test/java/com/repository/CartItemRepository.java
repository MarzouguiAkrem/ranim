package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
