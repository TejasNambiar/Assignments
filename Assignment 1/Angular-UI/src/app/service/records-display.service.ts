import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import {IStudent} from '../Student'

@Injectable({
  providedIn: 'root'
})
export class RecordsDisplayService {

  private url: string = "http://localhost:8000/api/student"

  constructor(private http: HttpClient) {}

  getStudentDetails(): Observable<any>{
    return this.http.get<any>(this.url)
  }
}
