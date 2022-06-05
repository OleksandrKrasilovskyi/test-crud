package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {

    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams () {
        List<Team> teams = this.teamService.getAll();

        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
        @GetMapping("/{teamId}")
        public ResponseEntity<Team> getTeamById (Long teamId){
            if (teamId == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Optional<Team> team = this.teamService.getById(teamId);

            if (team.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping("/teamId")
        public ResponseEntity<Team> saveCustomer (@RequestBody @Validated Team team){
            HttpHeaders headers = new HttpHeaders();

            if (team == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            this.teamService.save(team);
            return new ResponseEntity<>(team, headers, HttpStatus.CREATED);
        }

        @PutMapping("/teamId")
        public ResponseEntity<Team> updateCustomer (@RequestBody @Validated Team team){
            HttpHeaders headers = new HttpHeaders();

            if (team == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            this.teamService.save(team);

            return new ResponseEntity<>(team, headers, HttpStatus.OK);
        }

        @DeleteMapping("/teamId")
        public ResponseEntity<Team> deleteCustomer (Long id){
            Optional<Team> team = this.teamService.getById(id);

            if (team.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this.teamService.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
