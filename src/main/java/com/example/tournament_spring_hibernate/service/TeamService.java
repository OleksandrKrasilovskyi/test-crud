package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.mapper.TeamMapper;
import com.example.tournament_spring_hibernate.repository.TeamRepository;
import com.example.tournament_spring_hibernate.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final TournamentRepository tournamentRepository;

    @Transactional(readOnly = true)
    public List<TeamDTO> findAll(String tournamentName) {
        return teamMapper.mapEntityToDto(teamRepository.findAllByTournamentTournamentName(tournamentName));
    }

    @Transactional(readOnly = true)
    public TeamDTO findById(long teamId) {
        return teamMapper.mapEntityToDto(teamRepository.findById(teamId).orElseThrow());
    }

    public void createTeam(TeamDTO teamDTO) {
        final var team = teamMapper.mapDTOToEntity(teamDTO);
        final var tournament = tournamentRepository.findById(teamDTO.getTournamentId()).orElseThrow();
        team.setTournament(tournament);
        teamRepository.save(team);
    }

    public void update(TeamDTO teamDTO, long teamId) {
        final Team teamById = teamRepository.findById(teamId).orElseThrow();

        if (teamDTO.getTeamName() != null) {
            teamById.setTeamName(teamDTO.getTeamName());
        }
        if (teamDTO.getCapitanName() != null) {
            teamById.setCapitanName(teamDTO.getCapitanName());
        }
        if (teamDTO.getCoachName() != null) {
            teamById.setCoachName(teamDTO.getCoachName());
        }
    }

    public void deleteByFromHeader(long teamId) {
        teamRepository.deleteById(teamId);
    }

    @Transactional(readOnly = true)
    public TeamDTO findTeamByTeamName(String teamName) {
        return teamMapper.mapEntityToDto(teamRepository.findByTeamName(teamName));
    }

    @Transactional(readOnly = true)
    public TeamDTO findTeamByTeamNameAndCapitanName(String teamName, String capitanName) {
        return teamMapper.mapEntityToDto(
                teamRepository.findByTeamNameAndCapitanName(teamName, capitanName));
    }

    @Transactional(readOnly = true)
    public TeamDTO findTeamByTeamNameAndCapitanNameAndCoachName(String teamName,
                                                                String capitanName,
                                                                String coachName) {
        return teamMapper.mapEntityToDto(
                teamRepository.findByTeamNameAndCapitanNameAndCoachName(
                        teamName,
                        capitanName,
                        coachName));
    }

    @Transactional(readOnly = true)
    public TeamDTO findTeamByTeamNameAndCapitanNameAndCoachNameAndId(String teamName,
                                                                     String capitanName,
                                                                     String coachName,
                                                                     long id) {
        return teamMapper.mapEntityToDto(
                teamRepository.findByTeamNameAndCapitanNameAndCoachNameAndId(
                        teamName,
                        capitanName,
                        coachName, id));
    }
}
