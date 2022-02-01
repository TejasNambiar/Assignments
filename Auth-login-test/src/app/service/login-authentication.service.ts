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
  User !: any 

  constructor() { }

  validateUser(userName:string, password: string){
    // console.log(userName+" "+password)
    let userAccepted = this.user
      .filter(x => x.email == userName)
      .filter(x => x.password == password)
      
    // console.log(userAccepted)
    // localStorage.setItem('currentUser',JSON.stringify({name:this.firstName}))
    if(userAccepted && userAccepted.length === 1){
      // console.log(userAccepted[0].firstName)
      this.User = window.localStorage.setItem('currentUser',JSON.stringify({fname:userAccepted[0].firstName, lname:userAccepted[0].lastName, isLogged: true}))
      return true
    }
    this.User = window.localStorage.setItem('null',JSON.stringify({fname:null, lname:null, isLogged: false}))
    return false
  }

  currentUser(){
    localStorage.setItem('null',JSON.stringify({fname:null, lname:null, isLogged: false}))
    let localitems = window.localStorage.getItem('currentUser')
    console.log("localitems: "+localitems)
    this.User = localitems !== null ? JSON.parse(localitems) : localStorage.getItem('null')
    console.log(this.User)
    return this.User
  }

  logUserOut(){
    window.localStorage.clear()
  }
}
