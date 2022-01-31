import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CONST } from '../constants';
import { LoginAuthenticationService } from '../service/login-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: any;
  validate : boolean = false
  readonly LOGINCONST = CONST

  constructor(private fb: FormBuilder, private service:LoginAuthenticationService
    ,private router: Router) { }

  ngOnInit(): void {

    this.loginForm = this.fb.group({
      userName: ['', [Validators.required, Validators.minLength(3), Validators.email]],
      password: ['',Validators.required],
    });

  }

  save() {
    console.log(this.loginForm.form);
    console.log('Saved: ' + JSON.stringify(this.loginForm.value));
  } 

  validateLogin(){
    console.log(this.loginForm.value)
    let username = this.loginForm.value.userName
    let password = this.loginForm.value.password
    this.validate = this.service.validateUser(username,password)
    if(this.validate)
      this.router.navigate(["/homepage"]).then(() => {
        window.location.reload();
      });
  }
}
