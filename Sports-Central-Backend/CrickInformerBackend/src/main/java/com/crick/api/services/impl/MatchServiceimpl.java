    package com.crick.api.services.impl;


    import com.crick.api.entites.Match;
    import com.crick.api.repositories.MatchRepo;
    import com.crick.api.services.MatchService;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
    import org.jsoup.select.Elements;
    import org.springframework.stereotype.Service;



    import java.io.IOException;
    import java.util.*;

    @Service
    public class MatchServiceimpl implements MatchService {



        private MatchRepo matchrep1;

        public MatchServiceimpl(MatchRepo matchrep1) {
            this.matchrep1 = matchrep1;
        }

    //  match history all matches in our database
        @Override
        public List<Match> getAllMatches() {
            return this.matchrep1.findAll();
        }

    //    get live match
        @Override
        public List<Match> getLiveMatches() {
            List<Match> matches = new ArrayList<>();
            try {
                String url = "https://www.cricbuzz.com/cricket-match/live-scores";
                Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3").timeout(10_000) // 10 seconds
                        .followRedirects(true).get();
                // Print the entire document to see what is being fetched
                System.out.println(document);
                Elements liveScoreElements = document.select("div.flex.flex-col.gap-px");
                System.out.println("Live match elements: " + liveScoreElements.size());


                for (Element match : liveScoreElements) {
                    HashMap<String, String> liveMatchInfo = new LinkedHashMap<>();
                    String teamsHeading = match.select("div.text-cbTxtSec").text();
                    String matchNumberVenue = match.select("span").text();
                    Elements matchBatTeamInfo = match.select("div.cb-hmscg-bat-txt");
                    String battingTeam = matchBatTeamInfo.select("span.text-cbTxtPrim").text();
                    String scor     e = matchBatTeamInfo.select("span.text-cbTxtPrim").text();
                    Elements bowlTeamInfo = match.select("div.cb-hmscg-bwl-txt");
                    String bowlTeam = bowlTeamInfo.select("span.text-cbTxtSec").text();
                    String bowlTeamScore = bowlTeamInfo.select("div.cb-ovr-flo").text();
                    String textLive = match.select("div.cb-text-live").text();
                    String textComplete = match.select("div.cb-text-complete").text();
                    //getting match link
                    String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href").toString();

                    Match match1 = new Match();
                    match1.setTeamHeading(teamsHeading);
                    match1.setMatchNumberVenue(matchNumberVenue);
                    match1.setBattingTeam(battingTeam);
                    match1.setBattingTeamScore(score);
                    match1.setBowlTeam(bowlTeam);
                    match1.setBowlTeamScore(bowlTeamScore);
                    match1.setLiveText(textLive);
                    match1.setMatchLink(matchLink);
                    match1.setTextComplete(textComplete);
                    match1.setMatchStatus();

                    System.out.println(teamsHeading);


                    matches.add(match1);

    //                update the match in database


                    updateMatch(match1);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return matches;
        }
        private void updateMatch(Match match1) {

            Match match = this.matchrep1.findByTeamHeading(match1.getTeamHeading()).orElse(null);
            if (match == null) {
                this.matchrep1.save(match1);
            } else {

                match1.setMatchId(match.getMatchId());
                this.matchrep1.save(match1);
            }

        }
        @Override
        public List<List< String>> getpointTable() {
            List<List<String>> pointTable = new ArrayList<>();
            String tableURL = "https://www.cricbuzz.com/cricket-series/6732/icc-cricket-world-cup-2023/points-table";
            try {
                Document document = Jsoup.connect(tableURL).get();
                Elements table = document.select("table.cb-srs-pnts");
                Elements tableHeads = table.select("thead>tr>*");
                List<String> headers = new ArrayList<>();
                tableHeads.forEach(element -> {
                    headers.add(element.text());
                });
                pointTable.add(headers);
                Elements bodyTrs = table.select("tbody>*");
                bodyTrs.forEach(tr -> {
                    List<String> points = new ArrayList<>();
                    if (tr.hasAttr("class")) {
                        Elements tds = tr.select("td");
                        String team = tds.get(0).select("div.cb-col-84").text();
                        points.add(team);
                        tds.forEach(td -> {
                            if (!td.hasClass("cb-srs-pnts-name")) {
                                points.add(td.text());
                            }
                        });
    //                    System.out.println(points);
                        pointTable.add(points);
                    }


                });

                System.out.println(pointTable);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pointTable;
        }
    }