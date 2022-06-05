package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.entity.Tournament;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class TournamentClassRepository {

    private final List<Tournament> tournamentList;

    public List<Tournament> findAll() {
        return tournamentList;
    }

    public Tournament findById(long tournamentId) {
        return tournamentList.stream()
                .filter(tournament -> tournament.getId() == tournamentId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("There`s not tournament with id " + tournamentId));
    }

    @EventListener(ContextRefreshedEvent.class)
    public void enrichPeopleList() {
        IntStream.range(0, 10).forEach(i ->
                tournamentList.add(new Tournament()
                        .setId((long) i)
                        .setTournamentName(tournamentList.get(i).getTournamentName())
                        .setTeams(tournamentList.get(i).getTeams())
                        .setMatches(tournamentList.get(i).getMatches())));
    }

    public void deleteById(long tournamentId) {
        tournamentList.stream()
                .filter(tournament -> tournament.getId() == tournamentId)
                .forEach(tournamentList::remove);
    }
}
