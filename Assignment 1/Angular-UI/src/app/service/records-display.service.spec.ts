import { TestBed } from '@angular/core/testing';

import { RecordsDisplayService } from './records-display.service';

describe('RecordsDisplayService', () => {
  let service: RecordsDisplayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecordsDisplayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
