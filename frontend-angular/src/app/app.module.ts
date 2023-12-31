import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import {HttpClientModule} from "@angular/common/http";
import {ProductService} from "./service/product.service";
import {NgOptimizedImage} from "@angular/common";
import {RouterModule, RouterOutlet, Routes} from "@angular/router";

const routes: Routes = [
  {path: 'category/:id', component: ProductListComponent},
  {path: 'category', component: ProductListComponent},
  {path: 'products', component: ProductListComponent},
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: 'category/:id', component: ProductListComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgOptimizedImage,
    RouterOutlet
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
