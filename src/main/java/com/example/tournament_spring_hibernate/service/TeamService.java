package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.mapper.TeamMapper;
import com.example.tournament_spring_hibernate.repository.TeamClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamClassRepository teamClassRepository;
    private final TeamMapper teamMapper;

    public List<TeamDTO> findAll() {
        return teamMapper.mapEntityToDto(teamClassRepository.findAll());
    }

    public TeamDTO findById(long teamId) {
        return teamMapper.mapEntityToDto(teamClassRepository.findById(teamId));
    }

    public void updateTeamById(long teamId, TeamDTO teamDTO) {
        final Team teamById = teamClassRepository.findById(teamId);
        teamMapper.update(teamDTO, teamById);
    }

    public void deleteById(long teamId) {
        teamClassRepository.deleteById(teamId);
    }
}
