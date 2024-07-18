import { Component, Input } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css']
})
export class AddToCartComponent {
  @Input() product!: Product;

  constructor(private cartService: CartService) { }

  addToCart(): void {
    this.cartService.addToCart(this.product).subscribe();
  }
}


