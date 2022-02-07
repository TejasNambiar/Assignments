import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateComponent } from './create/create.component';
import { StoreModule } from '@ngrx/store';
import { ReadComponent } from './read/read.component';
import { LIST_REDUCER } from './course-state-store/list.reducer';

@NgModule({
  declarations: [
    AppComponent,
    CreateComponent,
    ReadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    StoreModule.forRoot({initialEntries: LIST_REDUCER})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
