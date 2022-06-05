package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Match;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @EntityGraph(attributePaths = {"tournament"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Match> findAllByTournamentTournamentName(String tournamentName);

    @Query("select match from Match match " +
            "where match.tournament.tournamentName = :tournamentName")
    List<Match> findAllByTournamentTournamentNameWithHQL(@Param("tournamentName") String tournamentName);
}


/*     private final List<Match> matches;

    public List<Match> findAll() {
        return matches;
    }

    public Match findById(long matchId) {
        return matches.stream()
                .filter(match -> match.getId() == matchId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("There`s not match with id " + matchId));
    }

    @EventListener(ContextRefreshedEvent.class)
    public void enrichPeopleList() {
        IntStream.range(0, 10).forEach(i ->
                matches.add(new Match()
                        .setId((long) i)
                        .setRound(matches.get(i).getRound())
                        .setFirstTeam(matches.get(i).getFirstTeam())
                        .setSecondTeam(matches.get(i).getSecondTeam())
                        .setScore(matches.get(i).getScore())));
    }

    public void deleteById(long matchId) {
        matches.stream()
                .filter(match -> match.getId() == matchId)
                .forEach(matches::remove);
    }
    *
 */