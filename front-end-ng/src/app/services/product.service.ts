import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Array<Product>> {
    return this.http.get('http://localhost:8080/products/all')
      .pipe(
        map(obj => obj as Array<Product>)
      )
  }

  getProductsByCategory(categoryId: number): Observable<Product[]> {
    return this.http.get(`http://localhost:8080/products/bycategory/${categoryId}`, )
      .pipe(
        map(obj => obj as Product[])
      )
  }
}
