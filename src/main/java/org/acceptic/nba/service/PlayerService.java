package org.acceptic.nba.service;

import org.acceptic.nba.model.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);

    List<Player> findAll();
}
