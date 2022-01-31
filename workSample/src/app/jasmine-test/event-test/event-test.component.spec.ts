import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { EventTestComponent } from './event-test.component';

describe('EventTestComponent', () => {
  let component: EventTestComponent;
  let fixture: ComponentFixture<EventTestComponent>;
  let debug: DebugElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventTestComponent);
    component = fixture.componentInstance;
    debug = fixture.debugElement
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should "Add Clicks" button is clicked', () => {
    const H1 = debug.query(By.css('h1'))
    const BUTTON = debug.query(By.css("#addClick"))
    // triggers the event as we want 
    // in this case button is clicked
    BUTTON.triggerEventHandler('click',{})
    fixture.detectChanges()
    expect(component.countClicks).toEqual(parseInt(H1.nativeElement.innerText));
  });
});
