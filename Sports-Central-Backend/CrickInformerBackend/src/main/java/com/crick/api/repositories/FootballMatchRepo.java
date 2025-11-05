package com.crick.api.repositories;

import com.crick.api.entites.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballMatchRepo extends JpaRepository<FootballMatch, Integer> {

    Optional<FootballMatch> findByMatchId(int matchId);

    Optional<FootballMatch> findByTeam1AndTeam2(String team1, String team2);
}
