package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.entity.Match;
import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.entity.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentMapper {

    public List<TournamentDTO> mapEntityToDto(List<Tournament> tournamentList) {
        return tournamentList.stream()
                .map(tournament -> new TournamentDTO()
                        .setId(tournament.getId())
                        .setTournamentName(tournament.getTournamentName())
                        .setTeamList(tournament.getTeams())
                        .setMatchList(tournament.getMatches()))
                .collect(Collectors.toList());
    }

    public TournamentDTO mapEntityToDto(Tournament tournament) {
        return new TournamentDTO()
                .setId(tournament.getId())
                .setTournamentName(tournament.getTournamentName())
                .setTeamList(tournament.getTeams())
                .setMatchList(tournament.getMatches());
    }

    public void update(TournamentDTO tournamentDTO, Tournament tournamentById) {
        final String tournamentName = tournamentDTO.getTournamentName();
        if (tournamentName != null) {
            tournamentById.setTournamentName(tournamentName);
        }

        final List<Team> teamList = tournamentDTO.getTeamList();
        if (teamList != null) {
            tournamentById.setTeams(teamList);
        }

        final List<Match> matchList = tournamentDTO.getMatchList();
        if (matchList != null) {
            tournamentById.setMatches(matchList);
        }
    }
}
