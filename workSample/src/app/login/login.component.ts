import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  loginForm: any;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {

    this.loginForm = this.fb.group({
      userName: ['', [Validators.required, Validators.minLength(3)]],
      password: ['',Validators.required],
    });

  }

  save() {
    console.log(this.loginForm.form);
    console.log('Saved: ' + JSON.stringify(this.loginForm.value));
  } 
}
