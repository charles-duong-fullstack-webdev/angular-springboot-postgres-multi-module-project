import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatNgdialogH2Component } from '././mat-ngdialog-h2.component';

describe('Matdialogh2Component', () => {
  let component: MatNgdialogH2Component;
  let fixture: ComponentFixture<MatNgdialogH2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatNgdialogH2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatNgdialogH2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
