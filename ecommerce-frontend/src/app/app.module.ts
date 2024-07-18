import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryService } from './services/category.service';
import { ProductService } from './services/product.service';

@NgModule({
  declarations: [
    AppComponent,
    CategoryListComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CategoryService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }

