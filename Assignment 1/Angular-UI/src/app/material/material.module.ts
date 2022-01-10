import { NgModule } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';

const materials = [
  MatCardModule,
  MatTableModule
]

@NgModule({
  imports: [materials],
  exports: [materials]
})
export class MaterialModule { }
