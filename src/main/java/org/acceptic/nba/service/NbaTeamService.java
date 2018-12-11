package org.acceptic.nba.service;

import org.acceptic.nba.model.Team;
import org.acceptic.nba.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NbaTeamService implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team findById(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No teams found"));
    }
}
