package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    // Spring data
    Optional<Tournament> findByTournamentName(String tournamentName);

    // HQL
    @Query("select tor from Tournament tor " +
            "where tor.tournamentName = :torName")
    Optional<Tournament> findByTournamentNameWithHQL(@Param("torName") String tournamentName);

//     //native sql
//    @Query(value = "select * from tournament tor " +
//            "where tor.tournament_name = :torName", nativeQuery = true)
//    Optional<Tournament> findByTournamentNameWithNativeSQL(@Param("torName") String tournamentName);
}
