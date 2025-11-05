package com.crick.api.repositories;

import com.crick.api.entites.Match;
//import com.crick.api.entities.Match; // Import the Match entity
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepo extends JpaRepository<Match, Integer> {
    // Fetch match by team heading
    Optional<Match> findByTeamHeading(String teamHeading);
}
