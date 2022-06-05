package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.service.TournamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private final TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.findAll());
    }

    @GetMapping("/{tournamentId}")
    public ResponseEntity<TournamentDTO> getMatchById(@PathVariable long tournamentId) {
        return ResponseEntity.ok(tournamentService.findById(tournamentId));
    }

    @PutMapping("/{tournamentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMatchById(@PathVariable long tournamentId,
                                @RequestBody TournamentDTO tournamentDTO) {
        tournamentService.updateTournamentById(tournamentId, tournamentDTO);
    }

    @RequestMapping(value = "/{tournamentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long tournamentId) {
        tournamentService.deleteById(tournamentId);
    }
}
