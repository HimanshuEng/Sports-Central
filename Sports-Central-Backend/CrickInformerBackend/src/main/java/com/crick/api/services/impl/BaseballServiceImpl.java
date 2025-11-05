package com.crick.api.services.impl;

import com.crick.api.entites.BaseballMatch;
import com.crick.api.repositories.BaseballMatchRepo;
import com.crick.api.services.BaseballService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseballServiceImpl implements BaseballService {

    private final BaseballMatchRepo baseballMatchRepo;

    public BaseballServiceImpl(BaseballMatchRepo baseballMatchRepo) {
        this.baseballMatchRepo = baseballMatchRepo;
    }

    @Override
    public List<String> getBaseballScores() {
        List<String> baseballScores = new ArrayList<>();
        try {
            String url = "https://www.flashscore.in/field-hockey/"; // ESPN Baseball URL (adjust if necessary)
            Document document = Jsoup.connect(url).get();

            Elements matchElements = document.select("div.event__match.event__match--withRowLink.event__match--scheduled.event__match--last.event__match--twoLine"); // Adjust based on HTML structure

            for (Element match : matchElements) {
                String team1 = match.select("div.event__participant.event__participant--away").text();
                String team2 = match.select("div.event__time").text();
                String matchTime = match.select("div.ScoreCell__Time.ScoreboardScoreCell__Time.h9.clr-gray-03").text();
                String score1 = match.select("div.ScoreCell__Score.ScoreCell__Score--scoreboard").text();
                String score2 = match.select("div.ScoreCell__Score.ScoreCell__Score--scoreboard").text();
                String matchStatus = match.select("span.status").text();
                String matchLink = match.select("a.match-link").attr("href");
                String matchVenue = match.select("div.LocationDetail__Item.LocationDetail__Item--headline").text();

                BaseballMatch baseballMatch = new BaseballMatch(team1, team2, score1, score2, matchStatus, matchLink, matchVenue, matchTime);
                baseballMatchRepo.save(baseballMatch);

                baseballScores.add(matchTime + " " + team1 + " vs " + team2 + " " + score1 + " - " + score2 + " (" + matchStatus + ")" + matchVenue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseballScores;
    }
}
