package com.crick.api.services.impl;

//import com.crick.api.entites.HockeyMatch;
import com.crick.api.entites.HockeyMatch;
import com.crick.api.repositories.HockeyMatchRepo;
//import com.crick.api.services.HockeyService;
import com.crick.api.services.hockeyservices;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HockeyServiceImpl implements hockeyservices {

    private final HockeyMatchRepo hockeyMatchRepo;

    public HockeyServiceImpl(HockeyMatchRepo hockeyMatchRepo) {
        this.hockeyMatchRepo = hockeyMatchRepo;
    }

    @Override
    public List<String> getHockeyScores() {
        List<String> hockeyScores = new ArrayList<>();
        try {
            String url = "https://www.espn.in/icehockey/scoreboard"; // ESPN Hockey URL (or any other URL relevant to hockey scores)
            Document document = Jsoup.connect(url).get();

            // Adjust the selector for hockey match details
            Elements matchElements = document.select("div.Scoreboard__Row"); // Adjust based on HTML structure for hockey

            for (Element match : matchElements) {
                String team1 = match.select("div.ScoreCell__TeamName.ScoreCell__TeamName--shortDisplayName.db").text(); // Adjust the selector
                String team2 = match.select("div.ScoreCell__Time.ScoreboardScoreCell__Time.h9.clr-gray-03").text();
                String matchtime = match.select("div.ScoreCell__Time.ScoreboardScoreCell__Time.h9.clr-gray-03").text();
                String score1 = match.select("div.ScoreCell__Score.h4.clr-gray-01.fw-heavy.tar.ScoreCell_Score--scoreboard.pl2").text(); // Adjust the selector
                String score2 = match.select("div.ScoreCell__Score.h4.clr-gray-01.fw-heavy.tar.ScoreCell_Score--scoreboard.pl2").text(); // Adjust the selector
                String matchStatus = match.select("span.status").text(); // Adjust the selector
                String matchLink = match.select("a.match-link").attr("href"); // Adjust selector for match link
                String matchVenue = match.select("div.LocationDetail__Item.LocationDetail__Item--headline").text(); // Adjust for venue if necessary

                HockeyMatch hockeyMatch = new HockeyMatch(team1, team2, score1, score2, matchStatus, matchLink, matchVenue, matchtime);
                hockeyMatchRepo.save(hockeyMatch); // Save to database

                hockeyScores.add(matchtime + "  " + team1 + " vs " + team2 + " " + score1 + " - " + score2 + " (" + matchStatus + ")" + matchVenue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hockeyScores;
    }
}
