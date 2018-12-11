package org.acceptic.nba.controller;

import org.acceptic.nba.mapping.PlayerMapper;
import org.acceptic.nba.model.Player;
import org.acceptic.nba.model.Team;
import org.acceptic.nba.model.dto.PlayerDto;
import org.acceptic.nba.service.PlayerService;
import org.acceptic.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerMapper playerMapper;

    @PostMapping(value = "/players")
    public Player createPlayer(@RequestBody PlayerDto playerDto) {
        String teamId = playerDto.getTeamId();
        Team team = teamService.findById(teamId);
        Player player = playerMapper.mapPlayerDtoToPlayer(playerDto);
        player.setTeam(team);
        return playerService.createPlayer(player);
    }

    @GetMapping(value = "/players")
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

}
