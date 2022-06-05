package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

     //spring data
    List<Team> findAllByTournamentTournamentName(String tournamentName);
    // HQL
    @Query("select team from Team team " +
            "where team.tournament.tournamentName = :tournamentName")
    List<Team> findAllByTournamentTournamentNameWithHQL(@Param("tournamentName") String tournamentName);


    //         //native sql
//    @Query(value = "select * from team " +
//            "join tournament tor on tor.tournament_id = team.tournament_id " +
//            "where tor.tournament_name = :tournamentName", nativeQuery = true)
//    List<Team> findAllByTournamentTournamentNameWithNative(@Param("tournamentName") String tournamentName);




//    private final List<Team> teams;
//
//    public List<Team> findAll() {
//        return teams;
//    }
//
//    public Team findById(long teamId) {
//        return teams.stream()
//                .filter(team -> team.getId() == teamId)
//                .findFirst()
//                .orElseThrow(() ->
//                        new IllegalArgumentException("There`s not team with id " + teamId));
//    }
//
//    @EventListener(ContextRefreshedEvent.class)
//    public void enrichPeopleList() {
//        IntStream.range(0, 10).forEach(i ->
//                teams.add(new Team()
//                        .setId((long) i)
//                        .setTeamName(teams.get(i).getTeamName())
//                        .setCapitanName(teams.get(i).getCapitanName())
//                        .setCoachName(teams.get(i).getCoachName())));
//    }
//
//    public void deleteById(long teamId) {
//        teams.stream()
//                .filter(team -> team.getId() == teamId)
//                .forEach(teams::remove);
//    }
}
