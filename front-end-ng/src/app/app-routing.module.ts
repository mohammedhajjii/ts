import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {CategoryComponent} from "./category/category.component";
import {ProductComponent} from "./product/product.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'categories', component: CategoryComponent},
  {path: 'products', component: ProductComponent, data: {roles: ['A', 'B']}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
