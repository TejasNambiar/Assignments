import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { ADD_DATA } from '../app-management/form.actions';
import { AppState } from '../app.state';
import { Form } from '../entity/form';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  form !: any

  constructor(private fb:FormBuilder, private store: Store<AppState>) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['',Validators.required]
    });
  }

  // reactive form create.component.html
  addData(){
    let dto: Form = this.form.value
    console.log(JSON.stringify(dto)+", username:: "+dto.username)
    this.store.dispatch(ADD_DATA({
      username: dto.username,
      email:dto.email, 
      phone:dto.phone
    }))
    this.form.reset()
  }

  // plain input create2.component.html
  addData2(name:string,email:string,number:string){
    console.log(this.form.value)
    this.store.dispatch(ADD_DATA({
      username: name, email:email, phone:number
    }))
  }
 
}
