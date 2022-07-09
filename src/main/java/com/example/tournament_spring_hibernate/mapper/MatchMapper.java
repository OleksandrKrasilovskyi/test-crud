package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MatchMapper {

    public List<MatchDTO> mapEntityToDto(Set<Match> matches) {
        return matches.stream()
                .map(match -> new MatchDTO()
                        .setId(match.getId())
                        .setRound(match.getRound())
                        .setFirstTeam(match.getFirstTeam())
                        .setSecondTeam(match.getSecondTeam())
                        .setScore(match.getScore()))
                .collect(Collectors.toList());
    }

    public MatchDTO mapEntityToDto(Match match) {

        return new MatchDTO()
                .setId(match.getId())
                .setRound(match.getRound())
                .setFirstTeam(match.getFirstTeam())
                .setSecondTeam(match.getSecondTeam())
                .setScore(match.getScore());
    }

    public Match mapDtoToEntity(MatchDTO matchDTO){
        return new Match()
                .setId(matchDTO.getId())
                .setRound(matchDTO.getRound())
                .setFirstTeam(matchDTO.getFirstTeam())
                .setSecondTeam(matchDTO.getSecondTeam())
                .setScore(matchDTO.getScore());
    }

    public List<Match> mapDtoToEntity(Set<MatchDTO> matches) {
        return matches.stream()
                .map(match -> new Match()
                        .setId(match.getId())
                        .setRound(match.getRound())
                        .setFirstTeam(match.getFirstTeam())
                        .setSecondTeam(match.getSecondTeam())
                        .setScore(match.getScore()))
                .collect(Collectors.toList());
    }
}
