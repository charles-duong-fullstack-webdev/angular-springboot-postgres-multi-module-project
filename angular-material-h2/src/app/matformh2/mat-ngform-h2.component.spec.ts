import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatNgformH2Component } from './mat-ngform-h2.component';

describe('Matformh2Component', () => {
  let component: MatNgformH2Component;
  let fixture: ComponentFixture<MatNgformH2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatNgformH2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatNgformH2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
