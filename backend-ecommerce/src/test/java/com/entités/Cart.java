package com.example.ecommercebackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> items;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Set<CartItem> getItems() { return items; }
    public void setItems(Set<CartItem> items) { this.items = items; }
}
