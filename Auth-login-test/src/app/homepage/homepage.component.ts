import { Component, OnInit } from '@angular/core';
import { LoginAuthenticationService } from '../service/login-authentication.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  userAuthenticated !:  any

  constructor(private service: LoginAuthenticationService) { }

  ngOnInit(): void {
    this.userAuthenticated = this.service.currentUser()?.isLogged
    console.log("window inside home:: "+this.userAuthenticated)
  }

}
