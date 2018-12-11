package org.acceptic.nba.mapping;

import org.acceptic.nba.model.Player;
import org.acceptic.nba.model.dto.PlayerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class PlayerMapper {

    public Player mapPlayerDtoToPlayer(@NotNull PlayerDto playerDto){
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        return player;
    }

}
