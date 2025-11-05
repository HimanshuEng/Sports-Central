package com.crick.api.controller;

//import com.crick.api.services.HockeyService;
import com.crick.api.services.hockeyservices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*") // Allow all origins during development
@RestController
@RequestMapping("/hockey")
public class HockeyMatchController {

    private final hockeyservices hockeyService;

    // Constructor to inject the HockeyService dependency
    public HockeyMatchController(hockeyservices hockeyService) {
        this.hockeyService = hockeyService;
    }

    // Get live hockey matches
    @GetMapping("/LiveScore")
    public ResponseEntity<List<String>> getLiveHockeyMatches() {
        // Get live match scores from the service
        List<String> liveHockeyScores = hockeyService.getHockeyScores();
        return new ResponseEntity<>(liveHockeyScores, HttpStatus.OK);
    }
}
