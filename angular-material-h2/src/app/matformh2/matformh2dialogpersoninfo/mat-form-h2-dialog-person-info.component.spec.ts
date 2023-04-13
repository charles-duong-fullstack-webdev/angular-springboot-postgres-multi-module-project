import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatFormH2DialogPersonInfoComponent } from './mat-form-h2-dialog-person-info.component';

describe('MatFormH2DialogPersonInfoComponent', () => {
  let component: MatFormH2DialogPersonInfoComponent;
  let fixture: ComponentFixture<MatFormH2DialogPersonInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatFormH2DialogPersonInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatFormH2DialogPersonInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
