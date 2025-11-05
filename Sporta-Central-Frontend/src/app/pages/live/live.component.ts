import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { ApiCallService } from '../../services/api-call.service';
import { CommonModule } from '@angular/common';
import { MatchCardComponent } from '../../components/match-card/match-card.component';

@Component({
  selector: 'app-live',
  standalone: true,
  imports: [MatchCardComponent,CommonModule],
  templateUrl: './live.component.html',
  styleUrl: './live.component.css',
  encapsulation: ViewEncapsulation.None,  
})
export class LiveComponent implements OnInit {
  LiveMatches:any
constructor(private _api:ApiCallService){

}
  ngOnInit(): void {
    this.LoadliveMatches();
    
  }

  private LoadliveMatches() {
    this._api.getLiveMatche().subscribe({
      next: data => {
        console.log(data);
        this.LiveMatches=data
      },
      error: error => { console.log(error); }
    });
  }
}