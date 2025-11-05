package com.crick.api.services.impl;

import com.crick.api.entites.FootballMatch;
import com.crick.api.repositories.FootballMatchRepo;
import com.crick.api.services.SportService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    private final FootballMatchRepo footballMatchRepo;

    public SportServiceImpl(FootballMatchRepo footballMatchRepo) {
        this.footballMatchRepo = footballMatchRepo;
    }

    @Override
    public List<String> getFootballScores() {
        List<String> footballScores = new ArrayList<>();
        try {
            String url = "https://www.espn.in/football/scoreboard"; // ESPN Football URL
            Document document = Jsoup.connect(url).get();

            Elements matchElements = document.select("div.Scoreboard__Row"); // Adjust based on HTML structure

            for (Element match : matchElements) {
                String team1 = match.select("div.ScoreCell__TeamName.ScoreCell__TeamName--shortDisplayName.db").text(); // Adjust the selector
                System.out.println("hhhhhhhhhh"+team1);
                String team2  = match.select("div.ScoreCell__Time.ScoreboardScoreCell__Time.h9.clr-gray-03").text();
                String matchtime  = match.select("div.ScoreCell__Time.ScoreboardScoreCell__Time.h9.clr-gray-03").text();
//                String league = match.select("div.Card__Header__Title__Wrapper.h3.Card__Header__Title.Card__Header__Title--no-theme").text(); // Adjust the selector
                String score1 = match.select("div.ScoreCell__Score.h4.clr-gray-01.fw-heavy.tar.ScoreCell_Score--scoreboard.pl2").text(); // Adjust the selector
                String score2 = match.select("div.ScoreCell__Score.h4.clr-gray-01.fw-heavy.tar.ScoreCell_Score--scoreboard.pl2").text(); // Adjust the selector
                String matchStatus = match.select("span.status").text(); // Adjust the selector
                String matchLink = match.select("a.match-link").attr("href"); // Adjust selector for match link
                String matchvenu = match.select("div.LocationDetail__Item.LocationDetail__Item--headline").text();
                FootballMatch footballMatch = new FootballMatch(team1,team2,score1, score2, matchStatus, matchLink,matchvenu,matchtime);
                footballMatchRepo.save(footballMatch); // Save to database

                footballScores.add(footballMatch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return footballScores;
    }
}
