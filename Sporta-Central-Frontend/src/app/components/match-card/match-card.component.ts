import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';  // Import CommonModule

@Component({
  selector: 'app-match-card',
  standalone: true,
  imports: [CommonModule],  // Include CommonModule here if you're using directives like ngFor
  templateUrl: './match-card.component.html',
  styleUrls: ['./match-card.component.css']  // Corrected styleUrls
})
export class MatchCardComponent {
  @Input() match:any
}
