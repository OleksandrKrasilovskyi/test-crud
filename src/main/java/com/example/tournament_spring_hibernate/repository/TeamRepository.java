package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Set<Team> findAllByTournamentTournamentName(String tournamentName);

    Team findByTeamName(String teamName);

    Team findByTeamNameAndCapitanName(String teamName,
                                      String capitanName);

    Team findByTeamNameAndCapitanNameAndCoachName(String teamName,
                                                  String capitanName,
                                                  String coachName);

    Team findByTeamNameAndCapitanNameAndCoachNameAndId(String teamName,
                                                       String capitanName,
                                                       String coachName,
                                                       Long id);
}
