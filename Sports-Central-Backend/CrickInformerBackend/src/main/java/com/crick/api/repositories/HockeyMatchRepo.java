package com.crick.api.repositories;

import com.crick.api.entites.HockeyMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HockeyMatchRepo extends JpaRepository<HockeyMatch, Long> {

    // Custom query to find a hockey match by its ID
    Optional<HockeyMatch> findByMatchId(Long matchId);

    // Custom query to find a hockey match by the two teams
    Optional<HockeyMatch> findByTeam1AndTeam2(String team1, String team2);
}
