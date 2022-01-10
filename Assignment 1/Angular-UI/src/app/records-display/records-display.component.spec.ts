import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordsDisplayComponent } from './records-display.component';

describe('RecordsDisplayComponent', () => {
  let component: RecordsDisplayComponent;
  let fixture: ComponentFixture<RecordsDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecordsDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecordsDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
