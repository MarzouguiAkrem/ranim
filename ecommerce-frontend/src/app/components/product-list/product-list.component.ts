import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  selectedCategoryId?: number;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    if (this.selectedCategoryId) {
      this.productService.getProductsByCategory(this.selectedCategoryId).subscribe(data => {
        this.products = data;
      });
    } else {
      this.productService.getProducts().subscribe(data => {
        this.products = data;
      });
    }
  }

  onCategoryChange(categoryId: number): void {
    this.selectedCategoryId = categoryId;
    this.loadProducts();
  }
}

