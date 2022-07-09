package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Tournament;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    // HQL
    @EntityGraph(attributePaths = {"teams", "matches"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select tor from Tournament tor ")
    List<Tournament> findAllTournamentsWithHQL();

    @EntityGraph(attributePaths = {"teams", "matches"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select tor FROM Tournament tor " +
            "where tor.id = :tournamentId")
    Tournament findByIdWithHQL(@Param("tournamentId") long tournamentId);

    @Modifying
    @Query("delete from Tournament tor " +
            "where tor.id = :tournamentId")
    void deleteByIdWithHQL(@Param("tournamentId") long tournamentId);

    @Modifying
    @Query("update Tournament tor set tor.tournamentName= :tournamentName " +
            "where tor.id = :tournamentId ")
    void updateTournamentByIdWithHQL(@Param("tournamentId") long tournamentId,
                                     @Param("tournamentName") String tournamentName);
}
