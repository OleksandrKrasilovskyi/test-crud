package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.entity.Match;
import com.example.tournament_spring_hibernate.repository.MatchRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService{

    private MatchRepository matchRepository;

    @Override
    public Optional<Match> getById(Long id) {
        log.info("IN MatchServiceImpl getById {}", id);
        return matchRepository.findById(id);
    }

    @Override
    public void save(Match match) {
        log.info("IN MatchServiceImpl save {}", match);
        matchRepository.save(match);
    }

    @Override
    public void deleteById(Long id) {
        log.info("IN MatchServiceImpl {}", id);
        matchRepository.deleteById(id);
    }

    @Override
    public List<Match> getAll() {
        log.info("IN MatchServiceImpl getAll");
        return matchRepository.findAll();
    }
}
