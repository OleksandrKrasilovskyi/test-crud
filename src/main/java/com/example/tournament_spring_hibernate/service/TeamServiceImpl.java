package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    TeamRepository teamRepository;

    @Override
    public Optional<Team> getById(Long id) {
        log.info("IN TeamServiceImpl findById {}", id);
        return teamRepository.findById(id);
    }

    @Override
    public void save(Team team) {
        log.info("IN TeamServiceImpl save {}", team);
        teamRepository.save(team);
    }

    @Override
    public void deleteById(Long id) {
        log.info("IN TeamServiceImpl delete {}", id);
        teamRepository.deleteById(id);
    }

    @Override
    public List<Team> getAll() {
        log.info("IN TeamServiceImpl getAll");
        return teamRepository.findAll();
    }
}
