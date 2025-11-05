import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Correct import
import { Observable } from 'rxjs'; // For Observable support
import { environment } from '../../environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class ApiCallService {

  constructor(private _httpClient: HttpClient) { }  // Corrected HttpClient

  getAllMatches(){
return this._httpClient.get(`${environment.apiurl}/match/allmatch`);
  }
  getLiveMatche(){
    return this._httpClient.get(`${environment.apiurl}/match/LiveScore`);
  }
  getPointTable(){
    return this._httpClient.get(`${environment.apiurl}/match/PointTable`);
  }
  getFootballScores(){
    return this._httpClient.get(`${environment.apiurl}/football/football-scores`);
  }
}
