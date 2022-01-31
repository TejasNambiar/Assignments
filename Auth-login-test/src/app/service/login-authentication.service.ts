import { Injectable } from '@angular/core';
import { empty } from 'rxjs';
import { DUMMY_DATA } from '../mock-data/Auth-Data';
import { DummyData } from '../model/dummy-data';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthenticationService {

  user = DUMMY_DATA
  validated !: DummyData
  noUser = window.localStorage.setItem('null',JSON.stringify({fname:null, lname:null, isLogged: false}))

  constructor() { }

  validateUser(userName:string, password: string){
    console.log(userName+" "+password)
    let userAccepted = this.user
      .filter(x => x.email == userName)
      .filter(x => x.password == password)
      
    console.log(userAccepted)
    // localStorage.setItem('currentUser',JSON.stringify({name:this.firstName}))
    if(userAccepted && userAccepted.length === 1){
      console.log(userAccepted[0].firstName)
      localStorage.setItem('currentUser',JSON.stringify({fname:userAccepted[0].firstName, lname:userAccepted[0].lastName, isLogged: true}))
      return true
    }
    this.noUser
    return false
  }

  currentUser(){
    let localitems = window.localStorage.getItem('currentUser')
    let todos = localitems !== null ? JSON.parse(localitems) : this.noUser
    console.log(todos)
    return todos
  }

  logUserOut(){
    window.localStorage.clear()
  }
}
