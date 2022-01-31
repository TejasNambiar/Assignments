import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AuthenticationService } from '../auth-service/authentication.service';

import { EmployeeComponent } from './employee.component';

describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;
  let authService: AuthenticationService

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeComponent ],
      providers: [AuthenticationService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    authService = TestBed.get(AuthenticationService)
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return the value "Salary Slip"', () => {
    let salSlip = component.gertSalarySlip()
    expect(salSlip).toEqual("Salary Slip");
  });

  it('should assert "checkAuthenticate" has been called', () => {
    spyOn(authService, 'checkAuthenticate')
    let salSlip = component.gertSalarySlip()
    expect(authService.checkAuthenticate).toHaveBeenCalled()
  });

  it('should check flow for "true" ', () => {
    spyOn(authService, 'checkAuthenticate').and.returnValue(true)
    let salSlip = component.gertSalarySlip()
    expect(salSlip).toEqual("Salary Slip")
  });

  it('should check flow for "false" ', () => {
    spyOn(authService, 'checkAuthenticate').and.returnValue(false)
    let salSlip = component.gertSalarySlip()
    expect(salSlip).toEqual("Not Authenticated")
  });
});
