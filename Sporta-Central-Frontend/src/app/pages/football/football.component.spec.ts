import { ComponentFixture, TestBed } from '@angular/core/testing';

import { footballComponent } from './football.component';

describe('FootballComponent', () => {
  let component: footballComponent;
  let fixture: ComponentFixture<footballComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [footballComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(footballComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
