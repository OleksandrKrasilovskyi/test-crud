package com.example.tournament_spring_hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TeamDTO {
    private Long tournamentId;
    private Long id;
    private String teamName;
    private String capitanName;
    private String coachName;
}
