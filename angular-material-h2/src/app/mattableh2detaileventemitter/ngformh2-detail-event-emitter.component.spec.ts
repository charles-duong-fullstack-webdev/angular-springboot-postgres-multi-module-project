import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ngformh2DetailEventEmitterComponent } from './ngformh2-detail-event-emitter.component';

describe('SampleEventEmitterComponent', () => {
  let component: Ngformh2DetailEventEmitterComponent;
  let fixture: ComponentFixture<Ngformh2DetailEventEmitterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ngformh2DetailEventEmitterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ngformh2DetailEventEmitterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
