import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { CartItem } from '../models/cart-item.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  total: number = 0;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.loadCart();
  }

  loadCart(): void {
    this.cartService.getCartItems().subscribe(items => {
      this.cartItems = items;
      this.calculateTotal();
    });
  }

  calculateTotal(): void {
    this.total = this.cartItems.reduce((acc, item) => acc + (item.product.price * item.quantity), 0);
  }
}
