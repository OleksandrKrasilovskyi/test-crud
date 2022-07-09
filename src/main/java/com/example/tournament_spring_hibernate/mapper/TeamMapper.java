package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamMapper {

    public List<TeamDTO> mapEntityToDto(Set<Team> teamList) {
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

    public Team mapDTOToEntity(TeamDTO teamDTO) {
        return new Team()
                .setId(teamDTO.getId())
                .setTeamName(teamDTO.getTeamName())
                .setCapitanName(teamDTO.getCapitanName())
                .setCoachName(teamDTO.getCoachName());
    }

    public List<Team> mapDtoToEntity(Set<TeamDTO> teamDTOSet) {
        return teamDTOSet.stream()
                .map(teamDTO -> new Team()
                        .setId(teamDTO.getId())
                        .setTeamName(teamDTO.getTeamName())
                        .setCapitanName(teamDTO.getCapitanName())
                        .setCoachName(teamDTO.getCoachName()))
                .collect(Collectors.toList());
    }
}
