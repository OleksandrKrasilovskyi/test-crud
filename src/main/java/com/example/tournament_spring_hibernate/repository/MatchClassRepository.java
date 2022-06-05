package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Match;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

@Repository
@AllArgsConstructor
public class MatchClassRepository {

    private final List<Match> matchList;

    public List<Match> findAll() {
        return matchList;
    }

    public Match findById(long matchId) {
        return matchList.stream()
                .filter(match -> match.getId() == matchId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("There`s not match with id " + matchId));
    }

    @EventListener(ContextRefreshedEvent.class)
    public void enrichMatchList() {
        IntStream.range(0, 10).forEach(i ->
                matchList.add(new Match()
                        .setId((long) i)
                        .setRound(matchList.get(i).getRound())
                        .setFirstTeam(matchList.get(i).getFirstTeam())
                        .setSecondTeam(matchList.get(i).getFirstTeam())
                        .setScore(matchList.get(i).getScore())));
    }

    public void deleteById(long matchId) {
        matchList.stream()
                .filter(match -> match.getId() == matchId)
                .forEach(matchList::remove);
    }
}
