import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../auth-service/authentication.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private authService: AuthenticationService) {
    this.authService.authenticate()
   }

  ngOnInit(): void {
  }

  gertSalarySlip(){
    if(this.authService.checkAuthenticate())
      return "Salary Slip"
    
    return "Not Authenticated"
  }

}
