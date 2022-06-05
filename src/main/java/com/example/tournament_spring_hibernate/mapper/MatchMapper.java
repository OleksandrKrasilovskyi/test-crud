package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchMapper {

    public List<MatchDTO> mapEntityToDto(List<Match> matches) {
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

    public void update(MatchDTO matchDTO, Match matchById) {
        final String newRound = matchDTO.getRound();
        if (newRound != null) {
            matchById.setRound(newRound);
        }

        final String firstTeam = matchDTO.getFirstTeam();
        if (firstTeam != null) {
            matchById.setFirstTeam(firstTeam);
        }

        final String secondTeam = matchDTO.getSecondTeam();
        if (secondTeam != null) {
            matchById.setSecondTeam(secondTeam);
        }

        final String score = matchDTO.getScore();
        if (score != null) {
            matchById.setScore(score);
        }
    }
}
