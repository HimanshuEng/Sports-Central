package com.crick.api.controller;

import com.crick.api.services.BaseballService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*") // Allow all origins during development
@RestController
@RequestMapping("/baseball")
public class BaseballMatchController {

    private final BaseballService baseballService;

    // Constructor to inject the BaseballService dependency
    public BaseballMatchController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    // Get live baseball matches
    @GetMapping("/LiveScore")
    public ResponseEntity<List<String>> getLiveBaseballMatches() {
        List<String> liveBaseballScores = baseballService.getBaseballScores(); // Get live scores
        return new ResponseEntity<>(liveBaseballScores, HttpStatus.OK);
    }
}
