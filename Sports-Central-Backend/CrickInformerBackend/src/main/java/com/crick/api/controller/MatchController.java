package com.crick.api.controller;

import com.crick.api.entites.Match;
import com.crick.api.services.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*") // Allow all origins during development
@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private final MatchService matchservice;

    // Constructor to inject the    MatchService dependency
    public MatchController(MatchService matchservice) {
        this.matchservice = matchservice;
    }

    // Get live matches
    @GetMapping("/LiveScore")
    public ResponseEntity<List<Match>> getLiveMatches() {
        System.out.println("call live method");
        return new ResponseEntity<>(this.matchservice.getLiveMatches(), HttpStatus.OK);
    }

    // Get all matches
    @GetMapping("/allmatch")
    public ResponseEntity<List<Match>> getAllMatches() {
        // Fetch and return all matches
        List<Match> allMatches = this.matchservice.getAllMatches();
        return new ResponseEntity<>(allMatches, HttpStatus.OK);
    }

    // Get point table
    @GetMapping("/PointTable")
    public ResponseEntity<?> getPointTable() {
        // Fetch and return the point table
        return new ResponseEntity<>(this.matchservice.getpointTable(), HttpStatus.OK);
    }
}
