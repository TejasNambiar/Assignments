import { ComponentFixture, fakeAsync, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { MaterialModule } from './material/material.module';
import { LoginAuthenticationService } from './service/login-authentication.service';

describe('AppComponent', () => {

  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;
  let authService: LoginAuthenticationService

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        MaterialModule
      ],
      declarations: [
        AppComponent
      ],
      providers: [LoginAuthenticationService]
    }).compileComponents();
  });
  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    authService = TestBed.get(LoginAuthenticationService)
    component = fixture.componentInstance;
    fixture.detectChanges()
  });

  it('should create the app', () => {
    component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });

  it(`should spy on Service currentUser method:: fails'`, () => {
    const dummyReturn = {
      fname: null,
      lname: null,
      isLogged: false
    }

    let currentUserSpy = spyOn(authService, 'currentUser').and.returnValue(dummyReturn)
    component.ngOnInit()
    fixture.whenStable().then(() => {
      fixture.detectChanges()
      let authenticated = component.userAuthenticated
      expect(authenticated.isLogged).toBeFalsy()
    })
  });

  it('should check valid:: default  and post validation', () => {
    expect(component.valid).toBeFalsy()

    const dummyReturn = {
      fname: "test 1",
      lname: "last 1",
      isLogged: true
    }

    let currentUserSpy = spyOn(authService, 'currentUser').and.returnValue(dummyReturn)
    component.ngOnInit()
    fixture.whenStable().then(() => {
      fixture.detectChanges()
      let authenticated = component.userAuthenticated
      expect(authenticated.isLogged).toBeTruthy()
      expect(component.valid).toBeTruthy()
    })
  });

  it('should check logout function', fakeAsync(() => {
 
      spyOn(authService,'logUserOut')
      component.logout()
      component.ngOnInit()
      spyOn(window.location, "assign").and.callFake(() => {
        return 
      })
        expect(authService.logUserOut).toHaveBeenCalled()
        expect(component.valid).toBeFalsy() 

  }));
});
