package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable long teamId) {
        return ResponseEntity.ok(teamService.findById(teamId));
    }

    @PutMapping("/{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeamById(@PathVariable long teamId,
                                 @RequestBody TeamDTO teamDTO) {
        teamService.updateTeamById(teamId, teamDTO);
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long teamId) {
        teamService.deleteById(teamId);
    }
}
