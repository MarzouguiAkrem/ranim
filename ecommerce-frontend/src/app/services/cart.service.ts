import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartItem } from '../models/cart-item.model';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private apiUrl = 'http://localhost:8080/api/cart-items'; // URL du backend

  constructor(private http: HttpClient) { }

  getCartItems(): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(this.apiUrl);
  }

  addToCart(product: Product): Observable<CartItem> {
    const cartItem = {
      product: product,
      quantity: 1 // Valeur par défaut, ajustez si nécessaire
    };
    return this.http.post<CartItem>(this.apiUrl, cartItem);
  }
}
