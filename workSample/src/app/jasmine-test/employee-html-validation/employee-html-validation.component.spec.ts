import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AuthenticationService } from '../auth-service/authentication.service';

import { EmployeeHtmlValidationComponent } from './employee-html-validation.component';

describe('EmployeeHtmlValidationComponent', () => {
  let component: EmployeeHtmlValidationComponent;
  let fixture: ComponentFixture<EmployeeHtmlValidationComponent>;
  let authService: AuthenticationService
  let h1: HTMLElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeHtmlValidationComponent ],
      providers: [AuthenticationService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeHtmlValidationComponent);
    authService = TestBed.get(AuthenticationService)
    // creates instance of h1 element
    h1 = fixture.nativeElement.querySelector('h1')
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should assert value for "h1" elesment to be value of component.salSlip', () => {
    component.getSalarySlip()
    /* Angular requires this to update dom elements after
       method call */
    fixture.detectChanges();
    expect(h1.textContent).toBe(component.salSlip);
  });
    
});
