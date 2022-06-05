package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.entity.Tournament;
import com.example.tournament_spring_hibernate.mapper.TournamentMapper;
import com.example.tournament_spring_hibernate.repository.TournamentClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TournamentService {

    private final TournamentClassRepository tournamentClassRepository;
    private final TournamentMapper tournamentMapper;

    public List<TournamentDTO> findAll() {
        return tournamentMapper.mapEntityToDto(tournamentClassRepository.findAll());
    }

    public TournamentDTO findById(long tournamentId) {
        return tournamentMapper.mapEntityToDto(tournamentClassRepository.findById(tournamentId));
    }

    public void updateTournamentById(long tournamentId, TournamentDTO tournamentDTO) {
        final Tournament tournamentById = tournamentClassRepository.findById(tournamentId);
        tournamentMapper.update(tournamentDTO, tournamentById);
    }

    public void deleteById(long tournamentId) {
        tournamentClassRepository.deleteById(tournamentId);
    }
}
