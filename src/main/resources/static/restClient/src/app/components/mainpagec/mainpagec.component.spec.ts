import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainpagecComponent } from './mainpagec.component';

describe('MainpagecComponent', () => {
  let component: MainpagecComponent;
  let fixture: ComponentFixture<MainpagecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainpagecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainpagecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
