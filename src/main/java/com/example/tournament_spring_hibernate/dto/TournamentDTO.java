package com.example.tournament_spring_hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class TournamentDTO {
    private Long id;
    private String tournamentName;
    private Set<TeamDTO> teamList;
    private Set<MatchDTO> matchList;
}
