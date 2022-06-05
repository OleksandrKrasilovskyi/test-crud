package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.entity.Match;
import com.example.tournament_spring_hibernate.entity.Team;
import com.example.tournament_spring_hibernate.service.MatchService;
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
@RequestMapping("/matches")
public class MatchController {

    private MatchService matchService;

    @GetMapping
    public ResponseEntity<List<Match>> getAllTeams () {
        List<Match> matches = this.matchService.getAll();

        if (matches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById (Long matchId){
        if (matchId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Match> match = this.matchService.getById(matchId);

        if (match.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/matchId")
    public ResponseEntity<Match> saveCustomer (@RequestBody @Validated Match match){
        HttpHeaders headers = new HttpHeaders();

        if (match == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.matchService.save(match);
        return new ResponseEntity<>(match, headers, HttpStatus.CREATED);
    }

    @PutMapping("/matchId")
    public ResponseEntity<Match> updateCustomer (@RequestBody @Validated Match match){
        HttpHeaders headers = new HttpHeaders();

        if (match == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.matchService.save(match);

        return new ResponseEntity<>(match, headers, HttpStatus.OK);
    }

    @DeleteMapping("/matchId")
    public ResponseEntity<Team> deleteCustomer (Long id){
        Optional<Match> match = this.matchService.getById(id);

        if (match.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.matchService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
