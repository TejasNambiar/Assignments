import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecordsDisplayService {

  private url: string = "http://localhost:8001/api/students"
  private dbUrl: string = "http://localhost:8001/api/students/postgre"

  constructor(private http: HttpClient) {}

  getStudentDetails(): Observable<any>{
    return this.http.get<any>(this.url)
  }
  getStudentDbDetails(): Observable<any>{
    return this.http.get<any>(this.dbUrl)
  }
}
