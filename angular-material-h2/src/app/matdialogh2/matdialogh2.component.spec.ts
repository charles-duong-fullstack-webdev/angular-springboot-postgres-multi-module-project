import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Matdialogh2Component } from './matdialogh2.component';

describe('Matdialogh2Component', () => {
  let component: Matdialogh2Component;
  let fixture: ComponentFixture<Matdialogh2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Matdialogh2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Matdialogh2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
