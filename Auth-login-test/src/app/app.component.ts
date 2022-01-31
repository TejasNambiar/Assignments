import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { empty } from 'rxjs';
import { LoginAuthenticationService } from './service/login-authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  userAuthenticated !:  any
  valid : boolean =false

  constructor(private service: LoginAuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.userAuthenticated = this.service.currentUser()
    if(this.userAuthenticated?.isLogged){
      this.valid = true
    }
    console.log("window inside app:: "+this.userAuthenticated?.isLogged)
  }

  
  logout(){
      this.service.logUserOut()
      this.valid = false
      this.router.navigate([""]).then(() => {window.location.reload()})
      
  }
}
