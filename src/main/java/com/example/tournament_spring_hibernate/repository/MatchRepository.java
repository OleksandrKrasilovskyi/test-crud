package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    //native SQL
    @Query(value = "SELECT * FROM match " +
            "JOIN tournament tor ON tor.tournament_id = match.tournament_id " +
            "WHERE tor.tournament_name = :tournamentName", nativeQuery = true)
    Set<Match> findAllByTournamentTournamentNameWithNativeSQL(@Param("tournamentName") String tournamentName);

    @Query(value = "SELECT * FROM match " +
            "JOIN tournament tor ON tor.tournament_id = match.tournament_id " +
            "WHERE match.match_id = :matchId", nativeQuery = true)
    Match findByIdWithNativeSQL(@Param("matchId") long matchId);

    @Modifying
    @Query(value = "DELETE FROM match " +
            "WHERE match.match_id = :matchId", nativeQuery = true)
    void deleteByIdWithNativeSQL(@Param("matchId") long matchId);

    @Modifying
    @Query(value = "INSERT INTO match (round, first_team, second_team, score, tournament_id) " +
            "VALUES (:round, :firstTeam, :secondTeam, :score, :tournamentId)",
            nativeQuery = true)
    void saveWithNativeSQL(@Param("round") String round,
                           @Param("firstTeam") String firstTeam,
                           @Param("secondTeam") String secondTeam,
                           @Param("score") String score,
                           @Param("tournamentId") long tournamentId);

    @Modifying
    @Query(value = "UPDATE match SET round = COALESCE(NULLIF(:round, ''), round)," +
            "first_team = COALESCE(NULLIF(:firstTeam, ''), first_team), " +
            "second_team = COALESCE(NULLIF(:secondTeam, ''), second_team), " +
            "score = COALESCE(NULLIF(:score, ''), score) " +
            "WHERE match_id = :matchId", nativeQuery = true)
    void updateMatchByIdWithNativeSQL(@Param("round") String round,
                                      @Param("firstTeam") String firstTeam,
                                      @Param("secondTeam") String secondTeam,
                                      @Param("score") String score,
                                      @Param("matchId") long matchId);
}
