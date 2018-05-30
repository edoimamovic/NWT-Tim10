import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnlyShowsComponent } from './only-shows.component';

describe('OnlyShowsComponent', () => {
  let component: OnlyShowsComponent;
  let fixture: ComponentFixture<OnlyShowsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnlyShowsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnlyShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
