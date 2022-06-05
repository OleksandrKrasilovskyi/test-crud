package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamMapper {

    public List<TeamDTO> mapEntityToDto(List<Team> teamList) {
        return teamList.stream()
                .map(team -> new TeamDTO()
                        .setId(team.getId())
                        .setTeamName(team.getTeamName())
                        .setCapitanName(team.getCapitanName())
                        .setCoachName(team.getCoachName()))
                .collect(Collectors.toList());
    }

    public TeamDTO mapEntityToDto(Team team) {
        return new TeamDTO()
                .setId(team.getId())
                .setTeamName(team.getTeamName())
                .setCapitanName(team.getCapitanName())
                .setCoachName(team.getCoachName());
    }

    public void update(TeamDTO teamDTO, Team teamById) {
        final String newTeamName = teamDTO.getTeamName();
        if (newTeamName != null) {
            teamById.setTeamName(newTeamName);
        }

        final String capitanName = teamDTO.getCapitanName();
        if (capitanName != null) {
            teamById.setCapitanName(capitanName);
        }

        final String coachName = teamDTO.getCoachName();
        if (coachName != null) {
            teamById.setCoachName(coachName);
        }
    }
}
