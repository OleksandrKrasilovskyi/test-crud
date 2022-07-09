package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.TeamDTO;
import com.example.tournament_spring_hibernate.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/tor/{tournamentName}")
    public ResponseEntity<List<TeamDTO>> getAllTeam(@PathVariable String tournamentName) {
        return ResponseEntity.ok(teamService.findAll(tournamentName));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/id/{teamId}")
    public ResponseEntity<TeamDTO> getById(@PathVariable long teamId) {
        return ResponseEntity.ok(teamService.findById(teamId));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping
    public ResponseEntity<TeamDTO> getTeamByIdFromParam(@RequestParam long teamId) {
        return ResponseEntity.ok(teamService.findById(teamId));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @PutMapping("/{teamId}")
    public void updateTeamById(@PathVariable long teamId,
                               @RequestBody TeamDTO teamDTO) {
        teamService.update(teamDTO, teamId);
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByHeader(@RequestHeader("team_id") long teamId) {
        teamService.deleteByFromHeader(teamId);
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @PostMapping
    public void createTeam(@RequestBody TeamDTO teamDTO) {
        this.teamService.createTeam(teamDTO);
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/{nameTeam}")
    public ResponseEntity<TeamDTO> getTeamByTeamName(@PathVariable String nameTeam) {
        return ResponseEntity.ok(teamService.findTeamByTeamName(nameTeam));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/{nameTeam}/{capitanName}")
    public ResponseEntity<TeamDTO> getTeamByTeamNameCapitanName(@PathVariable String nameTeam,
                                                                @PathVariable String capitanName) {
        return ResponseEntity.ok(teamService.findTeamByTeamNameAndCapitanName(nameTeam, capitanName));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/{nameTeam}/{capitanName}/{coachName}")
    public ResponseEntity<TeamDTO> getTeamByTeamNameCapitanNameCoachName(@PathVariable String nameTeam,
                                                                         @PathVariable String capitanName,
                                                                         @PathVariable String coachName) {
        return ResponseEntity.ok(teamService.findTeamByTeamNameAndCapitanNameAndCoachName(
                nameTeam,
                capitanName,
                coachName));
    }

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    @GetMapping("/{nameTeam}/{capitanName}/{coachName}/{id}")
    public ResponseEntity<TeamDTO> getTeamByTeamNameCapitanNameCoachNameId(@PathVariable String nameTeam,
                                                                           @PathVariable String capitanName,
                                                                           @PathVariable String coachName,
                                                                           @PathVariable long id) {
        return ResponseEntity.ok(teamService.findTeamByTeamNameAndCapitanNameAndCoachNameAndId(
                nameTeam,
                capitanName,
                coachName,
                id));
    }
}
