package org.acceptic.nba.service;

import org.acceptic.nba.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();

    Team findById(String id);
}
