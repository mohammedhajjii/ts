import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../models/product";
import {ProductService} from "../services/product.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRouteSnapshot} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  public dataSource!: MatTableDataSource<Product>;
  public colums: Array<string> = ["id", "name", "price", "category"];
  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;

  constructor(private productService:ProductService) {}


  ngOnInit(): void {
    this.productService
      .getAllProducts()
      .subscribe(
        value => this.dataSource = new MatTableDataSource<Product>(value)
      ,
        error => console.log(`${error}`),
        () => {
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
  }
}
