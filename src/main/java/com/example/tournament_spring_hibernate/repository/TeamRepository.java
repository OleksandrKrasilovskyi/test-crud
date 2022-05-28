package com.example.tournament_spring_hibernate.repository;

import com.example.tournament_spring_hibernate.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
