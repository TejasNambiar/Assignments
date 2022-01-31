import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../auth-service/authentication.service';

@Component({
  selector: 'app-employee-html-validation',
  templateUrl: './employee-html-validation.component.html',
  styleUrls: ['./employee-html-validation.component.css']
})
export class EmployeeHtmlValidationComponent implements OnInit {
  salSlip!: string;

  constructor(private authService: AuthenticationService) {
    this.authService.authenticate()
  }
   
  ngOnInit(): void {
  }
  
  getSalarySlip(){
    if(this.authService.checkAuthenticate())
      this.salSlip = "Salary Slip"
    
    this.salSlip = "Not Authenticated"
  }
}
