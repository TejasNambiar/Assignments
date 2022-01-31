import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { By } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialsModule } from '../materials/materials.module';

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
        BrowserAnimationsModule
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

    
    userNameTest.setValue("AMD")
    passwordTest.setValue("sdfsdfsdf")

    fixture.detectChanges()

    expect(component.loginForm.valid).toBeTruthy()
    expect(btn.nativeElement.disabled).toBeFalsy();
    
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

    expect(userNameTest.pristine).toBeTruthy();

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
