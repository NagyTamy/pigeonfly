import { TestBed } from '@angular/core/testing';

import { PigeonServiceService } from './pigeon-service.service';

describe('PigeonServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PigeonServiceService = TestBed.get(PigeonServiceService);
    expect(service).toBeTruthy();
  });
});
