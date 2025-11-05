package com.crick.api.services;

import com.crick.api.entites.Match;

import java.util.List;
import java.util.Map;

public interface MatchService {

//get all matcher

    List<Match> getAllMatches();




//    get live matcMapher
    List<Match> getLiveMatches();

//    get worldcup
    List<List<String>> getpointTable();
}
