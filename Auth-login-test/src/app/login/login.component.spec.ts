import { ComponentFixture, fakeAsync, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { By } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { route } from '../app-routing.module';
import { LoginAuthenticationService } from '../service/login-authentication.service';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ 
        LoginComponent,
        MatFormField
      ],
      imports: [
        ReactiveFormsModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        BrowserAnimationsModule,
        RouterTestingModule
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

  it('should check inital values match', () => {
    const LOGINFORMINIT = component.loginForm;
    const FORMMOCK = {
      userName: '',
      password: ''
    }
    expect(LOGINFORMINIT.value).toEqual(FORMMOCK);
  });

  it('should check submit button initially disabled', () => {
    
    fixture.detectChanges()
    expect(component.loginForm.valid).toBeFalsy()
    let btn = fixture.debugElement.query(By.css('#button'))
    expect(btn.nativeElement.disabled).toBeTruthy();
  });

  it('should check submit button enabled when form is valid', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]
    let btn = fixture.debugElement.query(By.css('#button'))

    expect(component.loginForm.invalid).toBeTruthy()
    expect(btn.nativeElement.disabled).toBeTruthy();

    
    userNameTest.setValue("sample1@abc.com")
    passwordTest.setValue("sample")

    fixture.detectChanges()

    expect(component.loginForm.valid).toBeTruthy()
    expect(btn.nativeElement.disabled).toBeFalsy();
    
  });

});
describe('Form Component', () =>{

  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let service: LoginAuthenticationService
  let router: Router

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ 
        LoginComponent 
      ],
      imports: [
        ReactiveFormsModule,
        RouterTestingModule.withRoutes(route)
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    router = TestBed.get(Router)
    service = TestBed.get(LoginAuthenticationService)
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be valid', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    userNameTest.setValue("sample1@abc.com")
    passwordTest.setValue("sample")

    expect(component.loginForm.valid).toBeTruthy();
  });

  it('should be invalid:: Username less than 3 characters', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    expect(userNameTest.pristine).toBeTruthy();

    userNameTest.setValue("AM")
    passwordTest.setValue("sdfsdfsdf")

    expect(component.loginForm.valid).toBeFalsy();
  });

  it('should be invalid:: Username not proper email', () => {
    
    let userNameTest = component.loginForm.controls["userName"]
    let passwordTest = component.loginForm.controls["password"]

    expect(userNameTest.pristine).toBeTruthy();

    userNameTest.setValue("AMD")
    passwordTest.setValue("sdfsdfsdf")

    expect(userNameTest.invalid).toBeTruthy();
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

  it('should call validateLogin Method: validate should be false',fakeAsync(()=>{
    component.validateLogin()
    spyOn(service,'validateUser').withArgs("abc","def").and.returnValue(false)
    // let navigateSpy = spyOn(router, 'navigate');
    // expect(navigateSpy).toHaveBeenCalledWith(["/homepage"])
    expect(component.validate).toBeFalsy()
  }))

  // it('should call validateLogin Method: validate should be true',fakeAsync(()=>{
  //   component.validateLogin()
  //   spyOn(service,'validateUser').withArgs("abc","def").and.callFake(() => {return true})
  //   fixture.detectChanges()
  //   // let navigateSpy = spyOn(router, 'navigate');
  //   // expect(navigateSpy).toHaveBeenCalledWith(["/homepage"])
  //   expect(component.validate).toBeTruthy()
  // }))
})
