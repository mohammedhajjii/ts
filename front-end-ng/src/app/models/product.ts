import {Category} from "./category";

export interface Product{

  id:string;
  name: string;
  price:number;
  category:Category;
}
