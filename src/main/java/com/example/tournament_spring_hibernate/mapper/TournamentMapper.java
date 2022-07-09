package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.entity.Tournament;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TournamentMapper {
    private final TeamMapper teamMapper;
    private final MatchMapper matchMapper;

    public List<TournamentDTO> mapEntityToDto(List<Tournament> tournamentSet) {
        return tournamentSet.stream()
                .map(tournament -> new TournamentDTO()
                        .setId(tournament.getId())
                        .setTournamentName(tournament.getTournamentName())
                        .setTeamList(new HashSet<>(teamMapper.mapEntityToDto(new HashSet<>(tournament.getTeams()))))
                        .setMatchList(new HashSet<>(matchMapper.mapEntityToDto(new HashSet<>(tournament.getMatches())))))
                .collect(Collectors.toList());
    }

    public TournamentDTO mapEntityToDto(Tournament tournament) {
        return new TournamentDTO()
                .setId(tournament.getId())
                .setTournamentName(tournament.getTournamentName())
                .setTeamList(new HashSet<>(teamMapper.mapEntityToDto(new HashSet<>(tournament.getTeams()))))
                .setMatchList(new HashSet<>(matchMapper.mapEntityToDto(new HashSet<>(tournament.getMatches()))));
    }

    public Tournament mapDtoToEntity(TournamentDTO tournamentDTO) {
        return new Tournament()
                .setId(tournamentDTO.getId())
                .setTournamentName(tournamentDTO.getTournamentName())
                .setTeams(new HashSet<>(teamMapper.mapDtoToEntity(tournamentDTO.getTeamList())))
                .setMatches(new HashSet<>(matchMapper.mapDtoToEntity(tournamentDTO.getMatchList())));
    }
}