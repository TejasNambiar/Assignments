import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { ADD_COURSE } from '../course-state-store/list.actions';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  constructor(private store: Store) { }

  ngOnInit(): void {
  }

  addCourse(name: string, url: string){
    this.store.dispatch(ADD_COURSE({
      name: name, url: url
    }))
  }

}
