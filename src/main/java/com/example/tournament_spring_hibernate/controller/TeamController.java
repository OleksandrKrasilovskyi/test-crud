package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.model.Team;
import com.example.tournament_spring_hibernate.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping("/teams")
    public String findAll(Model model){
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "team-list";
    }

    @GetMapping("/team-create")
    public String createTeamForm(Team team){
        return "team-create";
    }

    @PostMapping("/team-create")
    public String createTeam(Team team){
        teamService.saveTeam(team);
        return "redirect:/teams";
    }

    @GetMapping("team-delete/{id}")
    public String deleteTeam (@PathVariable("id") Long id){
        teamService.deleteById(id);
    return "redirect:/teams";
    }

    @GetMapping("/team-update/{id}")
    public String updateTeamForm(@PathVariable("id") Long id, Model model){
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        return "team-update";
    }

    @PostMapping("/team-update")
    public String updateTeam(Team team){
        teamService.saveTeam(team);
        return "redirect:/teams";
    }
}
