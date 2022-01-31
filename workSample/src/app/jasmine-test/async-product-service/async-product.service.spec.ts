import { TestBed } from '@angular/core/testing';

import { AsyncProductService } from './async-product.service';

describe('AsyncProductService', () => {
  let service: AsyncProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsyncProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
