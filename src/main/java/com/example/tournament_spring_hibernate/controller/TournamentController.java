package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.TournamentDTO;
import com.example.tournament_spring_hibernate.service.TournamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/all")
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.findAll());
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/id/{tournamentId}")
    public ResponseEntity<TournamentDTO> getMatchById(@PathVariable long tournamentId) {
        final var tournamentServiceById = tournamentService.findById(tournamentId);
        return ResponseEntity.ok(tournamentServiceById);
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/id")
    public ResponseEntity<TournamentDTO> getTeamByIdFromParam(@RequestParam long tournamentId) {
        return ResponseEntity.ok(tournamentService.findById(tournamentId));
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTournament(@RequestBody TournamentDTO tournamentDTO) {
        this.tournamentService.createTournament(tournamentDTO);
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @PutMapping("/{tournamentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMatchById(@PathVariable long tournamentId,
                                @RequestBody TournamentDTO tournamentDTO) {
        tournamentService.updateTournamentById(tournamentId, tournamentDTO);
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @RequestMapping(value = "/{tournamentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long tournamentId) {
        tournamentService.deleteById(tournamentId);
    }
}
