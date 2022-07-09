package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.MatchDTO;
import com.example.tournament_spring_hibernate.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/getAll")
    public ResponseEntity<List<MatchDTO>> getAllMatches(String tournamentName) {
        return ResponseEntity.ok(matchService.findAll(tournamentName));
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/id/{matchId}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable long matchId) {
        return ResponseEntity.ok(matchService.findById(matchId));
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @GetMapping("/id")
    public ResponseEntity<MatchDTO> getTeamByIdFromParam(@RequestParam long matchId) {
        return ResponseEntity.ok(matchService.findById(matchId));
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @PutMapping("/update/{matchId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMatchById(@PathVariable long matchId,
                                @RequestBody MatchDTO matchDTO) {
        matchService.update(matchId, matchDTO);
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @DeleteMapping("/id/{matchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long matchId) {
        matchService.deleteById(matchId);
    }

    @PreAuthorize("hasAnyAuthority('write')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMatch(@RequestBody MatchDTO matchDTO) {
        this.matchService.createMatch(matchDTO);
    }
}
