package org.acceptic.nba.mapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acceptic.nba.model.Team;
import org.acceptic.nba.model.dto.TeamDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public Set<Team> mapJsonToTeam(String teams) {
        return convertJsonToTeamDto(teams).stream()
                .map(this::convertDtoToTeam)
                .collect(Collectors.toSet());
    }

    private Set<TeamDto> convertJsonToTeamDto(String teams) {
        try {
            return mapper.readValue(teams, new TypeReference<Set<TeamDto>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse json");
        }
    }

    private Team convertDtoToTeam(@NotNull TeamDto teamDto) {
        Team team = new Team();
        BeanUtils.copyProperties(teamDto, team);
        return team;
    }
}
