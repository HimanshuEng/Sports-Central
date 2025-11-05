package com.crick.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FootballMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String team1;
    private String team2;
    private String score1;
    private String score2;
    private String matchStatus; // Live, Completed, etc.
    private String matchLink;
    private String matchVenu;
    private String matchtime;


    public FootballMatch() { } // <-- REQUIRED for JPA / Jackson



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

    public String getMatchVenu() {
        return matchVenu;
    }

    public void setMatchVenu(String matchVenu) {
        this.matchVenu = matchVenu;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "FootballMatch{" +
                "matchId=" + matchId +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", score1='" + score1 + '\'' +
                ", score2='" + score2 + '\'' +
                ", matchStatus='" + matchStatus + '\'' +
                ", matchLink='" + matchLink + '\'' +
                ", matchVenu='" + matchVenu + '\'' +
                ", matchtime='" + matchtime + '\'' +
                '}';
    }

}
