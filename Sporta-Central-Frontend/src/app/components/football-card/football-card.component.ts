import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-football-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './football-card.component.html',
  styleUrl: './football-card.component.css'
})
export class FootballCardComponent {
@Input() football:any
}
