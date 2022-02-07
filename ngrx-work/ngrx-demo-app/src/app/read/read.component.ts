import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { AppState } from '../app.state';
import { CLEAR_LIST, REMOVE_COURSE } from '../course-state-store/list.actions';
import { Course } from '../entity/course';

@Component({
  selector: 'app-read',
  templateUrl: './read.component.html',
  styleUrls: ['./read.component.css']
})
export class ReadComponent implements OnInit {

  readCourses !: Observable<Course[]>

  constructor(private store: Store<AppState>) {
    this.readCourses = store.select('initialEntries')
   }

  ngOnInit(): void {
  }

  removeProduct(course: Course){
    this.store.dispatch(REMOVE_COURSE(course))
  }

  clearEntries () {
    this.store.dispatch(CLEAR_LIST());
  }
}
