import { Component, OnInit } from '@angular/core';
import { AsyncProductService } from '../async-product-service/async-product.service';

@Component({
  selector: 'app-async-product-list',
  templateUrl: './async-product-list.component.html',
  styleUrls: ['./async-product-list.component.css']
})
export class AsyncProductListComponent implements OnInit {

  searchText !: any
  tempProductList: any[] = []

  constructor(private productService: AsyncProductService) { }

  ngOnInit(): void {
    this.productService.getProductList()
                          .subscribe( data=> {
                            this.tempProductList = data
                          })
  }

  filterProductList(event:any){
    let value = this.searchText;
    this.productService.filterProductList(value)
                          .then(data =>{
                            this.tempProductList = data
                        })
  }

}
