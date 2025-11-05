package com.crick.api.repositories;

import com.crick.api.entites.BaseballMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseballMatchRepo extends JpaRepository<BaseballMatch, Integer> {

    Optional<BaseballMatch> findByMatchId(int matchId);

    Optional<BaseballMatch> findByTeam1AndTeam2(String team1, String team2);
}
