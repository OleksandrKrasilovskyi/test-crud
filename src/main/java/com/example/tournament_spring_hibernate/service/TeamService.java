package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> getById(Long id);

    void save(Team team);

    void deleteById(Long id);

    List<Team> getAll();
}
