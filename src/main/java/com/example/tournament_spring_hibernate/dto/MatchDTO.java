package com.example.tournament_spring_hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class MatchDTO {
    private Long tournamentId;
    private Long id;
    private String round;
    private String firstTeam;
    private String secondTeam;
    private String score;
}
