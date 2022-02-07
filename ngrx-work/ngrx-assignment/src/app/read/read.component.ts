import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { CLEAR_LIST, REMOVE_DATA } from '../app-management/form.actions';
import { FORM_DATA } from '../app-management/form.selector';
import { AppState } from '../app.state';

@Component({
  selector: 'app-read',
  templateUrl: './read_list.component.html',
  styleUrls: ['./read.component.css']
})
export class ReadComponent implements OnInit {

  readData$ !: Observable<Form[]>
  readDataSelect$ !: Observable<Form[]>
  displayedColumns: string[] = ['username', 'phone', 'email'];
  // dataSource !: Observable<form[]>;


  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.readData$ = this.store.select("formEnteries")
    this.readDataSelect$ = this.store.pipe(select(FORM_DATA))
    // for read2.component.html -> matTable
    // this.dataSource = this.store.select("formEnteries")
    // console.log('dataSource:: '+this.dataSource)
    console.log("reading data:: "+this.readData$.toString())
    console.log("reading data:: "+this.readDataSelect$)
  }

  clearEntries () {
    this.store.dispatch(CLEAR_LIST());
  }

  removeProduct(data: Form){
    console.log("Data from list:: "+JSON.stringify(data))
    this.store.dispatch(REMOVE_DATA(data))
  }
}
