package com.example.tournament_spring_hibernate.dto;

import com.example.tournament_spring_hibernate.entity.Match;
import com.example.tournament_spring_hibernate.entity.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class TournamentDTO {

    private Long id;
    private String tournamentName;
    private List<Team> teamList;
    private List<Match> matchList;
}
