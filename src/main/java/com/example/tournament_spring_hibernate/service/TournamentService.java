package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.mapper.TournamentMapper;
import com.example.tournament_spring_hibernate.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;

    @Transactional(readOnly = true)
    public List<TournamentDTO> findAll() {
        return tournamentMapper.mapEntityToDto(tournamentRepository.findAllTournamentsWithHQL());
    }

    @Transactional(readOnly = true)
    public TournamentDTO findById(long tournamentId) {
        return tournamentMapper.mapEntityToDto(tournamentRepository.findByIdWithHQL(tournamentId));
    }

    public void createTournament(TournamentDTO tournamentDTO) {
        tournamentRepository.save(tournamentMapper.mapDtoToEntity(tournamentDTO));
    }

    public void updateTournamentById(long tournamentId, TournamentDTO tournamentDTO) {
        tournamentRepository.updateTournamentByIdWithHQL(tournamentId, tournamentDTO.getTournamentName());
    }

    public void deleteById(long tournamentId) {
        tournamentRepository.deleteByIdWithHQL(tournamentId);
    }
}
