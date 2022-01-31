import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  constructor() { }
  data: String = "parent component information has been passed"
  childData: String = "";
  items = ['item1', 'item2', 'item3', 'item4'];

  ngOnInit(): void {
  }

  parentFunction(data:String){
    this.childData = data;
  }

  addItem(newItem: string) {
    this.items.push(newItem);
  }

}
