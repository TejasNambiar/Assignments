import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AsyncProductService {

  productList = PRODUCT_LIST

  filterProductList(searchString: string) {
    
    return of(
        this.productList.filter(
          product => product.title.toLowerCase().indexOf(searchString) > -1)
        ).toPromise();
  }
  getProductList() {
    return of(this.productList);
  }

  constructor() { }
}

export const PRODUCT_LIST = [
  {
    "title":"Brown eggs",
    "type" : "diary",
    "description": "Raw Organic Stuff",
    "filename": "abc.jpg",
    "price":23.1,
    "rating": 4
  },
  {
    "title":"Sweet fresh strawberry",
    "type" : "diary",
    "description": "Raw Organic Stuff",
    "filename": "abc.jpg",
    "price":23.1,
    "rating": 4
  },
  {
    "title":"Fresh fish from farm",
    "type" : "Meat",
    "description": "Raw Organic Stuff",
    "filename": "abc.jpg",
    "price":25.1,
    "rating": 7
  },
]
