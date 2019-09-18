import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PigeonListComponent } from './pigeon-list.component';

describe('PigeonListComponent', () => {
  let component: PigeonListComponent;
  let fixture: ComponentFixture<PigeonListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PigeonListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PigeonListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
