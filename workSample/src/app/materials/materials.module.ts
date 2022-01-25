import { NgModule } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';

const Modules = [
  MatButtonModule,
  MatInputModule,
  MatFormFieldModule,
  MatCardModule
]

@NgModule({
  imports: [Modules],
  exports: [Modules]
})
export class MaterialsModule { }
