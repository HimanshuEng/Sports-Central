package com.crick.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class BaseballMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;
    private String team1;
    private String team2;
    private String score1;
    private String score2;
    private String matchStatus;
    private String matchLink;
    private String matchVenue;
    private String matchTime;

    // Constructors, Getters, Setters, and toString method

    public BaseballMatch(String team1, String team2, String score1, String score2, String matchStatus, String matchLink, String matchVenue, String matchTime) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.matchStatus = matchStatus;
        this.matchLink = matchLink;
        this.matchVenue = matchVenue;
        this.matchTime = matchTime;
    }

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getMatchLink() {
        return matchLink;
    }

    public void setMatchLink(String matchLink) {
        this.matchLink = matchLink;
    }

    public String getMatchVenue() {
        return matchVenue;
    }

    public void setMatchVenue(String matchVenue) {
        this.matchVenue = matchVenue;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    @Override
    public String toString() {
        return "BaseballMatch{" +
                "matchId=" + matchId +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", score1='" + score1 + '\'' +
                ", score2='" + score2 + '\'' +
                ", matchStatus='" + matchStatus + '\'' +
                ", matchLink='" + matchLink + '\'' +
                ", matchVenue='" + matchVenue + '\'' +
                ", matchTime='" + matchTime + '\'' +
                '}';
    }
}
