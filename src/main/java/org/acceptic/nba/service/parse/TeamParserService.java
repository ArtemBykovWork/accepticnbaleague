package org.acceptic.nba.service.parse;

import org.acceptic.nba.mapping.TeamMapper;
import org.acceptic.nba.model.Team;
import org.acceptic.nba.repository.TeamRepository;
import org.acceptic.nba.service.api.TeamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeamParserService implements ParserService{

    @Autowired
    private TeamClient teamClient;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private TeamRepository teamRepository;

    public void collectAllTeams(){
        Set<Team> teams = teamMapper.mapJsonToTeam(teamClient.findAll());
        teams.forEach(team -> teamRepository.save(team));
    }

}
