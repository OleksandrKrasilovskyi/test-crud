package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.mapper.MatchMapper;
import com.example.tournament_spring_hibernate.repository.MatchRepository;
import com.example.tournament_spring_hibernate.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final TournamentRepository tournamentRepository;

    @Transactional(readOnly = true)
    public List<MatchDTO> findAll(String tournamentName) {
        return matchMapper.mapEntityToDto(matchRepository.findAllByTournamentTournamentNameWithNativeSQL(tournamentName));
    }

    @Transactional(readOnly = true)
    public MatchDTO findById(long matchId) {
        return matchMapper.mapEntityToDto(matchRepository.findByIdWithNativeSQL(matchId));
    }

    public void deleteById(long matchId) {
        matchRepository.deleteByIdWithNativeSQL(matchId);
    }

    public void createMatch(MatchDTO matchDTO) {
        final var match = matchMapper.mapDtoToEntity(matchDTO);
        final var tournament = tournamentRepository.findById(matchDTO.getTournamentId()).orElseThrow();
        match.setTournament(tournament);
        long tournamentId = matchDTO.getTournamentId();
        matchRepository.saveWithNativeSQL(matchDTO.getRound(), matchDTO.getFirstTeam(), matchDTO.getSecondTeam(), matchDTO.getScore(), tournamentId);
    }

    public void update(long matchId, MatchDTO matchDTO) {
        matchRepository.updateMatchByIdWithNativeSQL(matchDTO.getRound(),
                matchDTO.getFirstTeam(),
                matchDTO.getSecondTeam(),
                matchDTO.getScore(),
                matchId);
    }
}
