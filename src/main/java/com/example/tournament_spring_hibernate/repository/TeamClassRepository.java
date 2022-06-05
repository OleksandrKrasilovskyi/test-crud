package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

@Repository
@AllArgsConstructor
public class TeamClassRepository {

    private final List<Team> teamList;

    public List<Team> findAll() {
        return teamList;
    }

    public Team findById(long teamId) {
        return teamList.stream()
                .filter(team -> team.getId() == teamId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("There`s not team with id " + teamId));
    }

    @EventListener(ContextRefreshedEvent.class)
    public void enrichPeopleList() {
        IntStream.range(0, 10).forEach(i ->
                teamList.add(new Team()
                        .setId((long) i)
                        .setTeamName(teamList.get(i).getTeamName())
                        .setCapitanName(teamList.get(i).getCapitanName())
                        .setCoachName(teamList.get(i).getCoachName())));
    }

    public void deleteById(long teamId) {
        teamList.stream()
                .filter(team -> team.getId() == teamId)
                .forEach(teamList::remove);
    }
}
