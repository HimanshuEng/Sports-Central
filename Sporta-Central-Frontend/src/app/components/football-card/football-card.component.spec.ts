import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FootballCardComponent } from './football-card.component';

describe('FootballCardComponent', () => {
  let component: FootballCardComponent;
  let fixture: ComponentFixture<FootballCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FootballCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FootballCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
