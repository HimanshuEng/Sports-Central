  import { CommonModule } from '@angular/common';
  import { Component, OnInit } from '@angular/core';
  import { MatchCardComponent } from '../../components/match-card/match-card.component';
  import { ApiCallService } from '../../services/api-call.service';
  import { FootballCardComponent } from "../../components/football-card/football-card.component";

  @Component({
    selector: 'app-football',
    standalone: true,
    imports: [CommonModule, MatchCardComponent, FootballCardComponent],
    templateUrl: './football.component.html',
    styleUrl: './football.component.css'
  })
  export class footballComponent implements OnInit {
    FootballScores:any
    constructor(private _api:ApiCallService){

    }
    ngOnInit(): void {
      this.LoadFootballScores();
      
    }
    private LoadFootballScores() {
      this._api.getFootballScores().subscribe({
        next: data => {
          console.log(data);
          this.FootballScores=data;
        },
        error: error => { console.log(error); }
      });
    }
  }
