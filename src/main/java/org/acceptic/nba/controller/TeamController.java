package org.acceptic.nba.controller;

import org.acceptic.nba.model.Team;
import org.acceptic.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

}
