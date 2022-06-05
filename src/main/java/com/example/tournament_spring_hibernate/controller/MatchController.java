package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/match")

public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        return ResponseEntity.ok(matchService.findAll());
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable long matchId) {
        return ResponseEntity.ok(matchService.findById(matchId));
    }

    @PutMapping("/{matchId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMatchById(@PathVariable long matchId,
                               @RequestBody MatchDTO matchDTO) {
        matchService.updateMatchById(matchId, matchDTO);
    }

    @RequestMapping(value = "/{matchId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long matchId) {
        matchService.deleteById(matchId);
    }
}
