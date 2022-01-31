import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialsModule } from './materials/materials.module';
import { LoginComponent } from './login/login.component';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { AppRoutingModule } from './app-routing.module';
import { EmployeeComponent } from './jasmine-test/employee/employee.component';
import { EmployeeHtmlValidationComponent } from './jasmine-test/employee-html-validation/employee-html-validation.component';
import { EventTestComponent } from './jasmine-test/event-test/event-test.component';
import { AsyncProductListComponent } from './jasmine-test/async-product-list/async-product-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ParentComponent,
    ChildComponent,
    EmployeeComponent,
    EmployeeHtmlValidationComponent,
    EventTestComponent,
    AsyncProductListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
