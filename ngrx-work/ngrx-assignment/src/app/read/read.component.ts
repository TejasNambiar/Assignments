import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { CLEAR_LIST, REMOVE_DATA } from '../app-management/form.actions';
import { AppState } from '../app.state';
import { form } from '../entity/form';

@Component({
  selector: 'app-read',
  templateUrl: './read_list.component.html',
  styleUrls: ['./read.component.css']
})
export class ReadComponent implements OnInit {

  readData !: Observable<form[]>
  displayedColumns: string[] = ['username', 'phone', 'email'];
  dataSource !: Observable<form[]>;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.readData = this.store.select("formEnteries")
    this.dataSource = this.store.select("formEnteries")
    console.log("reading data:: "+this.readData.toString())
    console.log('dataSource:: '+this.dataSource)
  }

  clearEntries () {
    this.store.dispatch(CLEAR_LIST());
  }

  removeProduct(data: form){
    console.log("Data from list:: "+JSON.stringify(data))
    this.store.dispatch(REMOVE_DATA(data))
  }
}
