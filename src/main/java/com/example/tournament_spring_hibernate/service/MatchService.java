package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.entity.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {

    Optional<Match> getById(Long Id);

    void save(Match match);

    void deleteById(Long id);

    List<Match> getAll();
}
