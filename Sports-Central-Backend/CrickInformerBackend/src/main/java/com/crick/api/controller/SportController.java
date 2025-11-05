package com.crick.api.controller;

import com.crick.api.services.SportService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@CrossOrigin(origins = "*") // Allow all origins during development
@RestController
@RequestMapping("/football")
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/football-scores")
    public List<String> getFootballScores() {
        return sportService.getFootballScores();
    }
}
