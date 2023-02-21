import { TestBed } from '@angular/core/testing';

import { BookingOperationsService } from './booking-operations.service';

describe('BookingOperationsService', () => {
  let service: BookingOperationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingOperationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
