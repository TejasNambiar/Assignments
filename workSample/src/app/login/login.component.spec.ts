import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ 
        LoginComponent 
      ],
      imports: [
        ReactiveFormsModule
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
describe('Form Component', () =>{

  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ 
        LoginComponent 
      ],
      imports: [
        ReactiveFormsModule
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be valid', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    userNameTest.setValue("AMD")
    passwordTest.setValue("sdfsdfsdf")

    expect(component.loginForm.valid).toBeTruthy();
  });

  it('should be invalid:: Username less than 3 characters', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    userNameTest.setValue("AM")
    passwordTest.setValue("sdfsdfsdf")

    expect(component.loginForm.valid).toBeFalsy();
  });
  it('should be invalid:: Username empty', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    userNameTest.setValue(null)
    passwordTest.setValue("sdfsdfsdf")

    expect(component.loginForm.valid).toBeFalsy();
  });

  it('should be invalid:: Password empty', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    userNameTest.setValue("AMD")
    passwordTest.setValue(null)

    expect(component.loginForm.valid).toBeFalsy();
  });
})
