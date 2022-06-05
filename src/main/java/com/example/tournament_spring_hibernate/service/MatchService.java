package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.entity.Match;
import com.example.tournament_spring_hibernate.mapper.MatchMapper;
import com.example.tournament_spring_hibernate.repository.MatchClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {


    private final MatchClassRepository matchClassRepository;
    private final MatchMapper matchMapper;

    public List<MatchDTO> findAll() {
        return matchMapper.mapEntityToDto(matchClassRepository.findAll());
    }

    public MatchDTO findById(long matchId) {
        return matchMapper.mapEntityToDto(matchClassRepository.findById(matchId));
    }

    public void updateMatchById(long matchId, MatchDTO matchDTO) {
        final Match matchById = matchClassRepository.findById(matchId);
        matchMapper.update(matchDTO, matchById);
    }

    public void deleteById(long matchId) {
        matchClassRepository.deleteById(matchId);
    }
}
