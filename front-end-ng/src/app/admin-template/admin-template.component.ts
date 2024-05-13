import {AfterViewInit, Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrl: './admin-template.component.css'
})
export class AdminTemplateComponent implements OnInit{


  constructor(private router:Router) {
  }

  ngOnInit() {

  }


  getCategories() {
      this.router.navigate(['categories'])
  }

  getProducts() {
    this.router.navigate(['products'])
  }
}
