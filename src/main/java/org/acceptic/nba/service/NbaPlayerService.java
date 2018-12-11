package org.acceptic.nba.service;

import org.acceptic.nba.model.Player;
import org.acceptic.nba.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NbaPlayerService implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }
}
