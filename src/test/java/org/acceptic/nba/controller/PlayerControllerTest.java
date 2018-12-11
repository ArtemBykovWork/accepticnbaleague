package org.acceptic.nba.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acceptic.nba.mapping.PlayerMapper;
import org.acceptic.nba.model.Player;
import org.acceptic.nba.model.Team;
import org.acceptic.nba.model.dto.PlayerDto;
import org.acceptic.nba.repository.TeamRepository;
import org.acceptic.nba.service.NbaTeamService;
import org.acceptic.nba.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    private static final String PLAYERS_URL = "/players";
    private static final String TEAM_ID = "teamId";
    private static final String CONTENT_TYPE = "Content-type";
    private PlayerDto playerDto;
    private Team team;
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private PlayerController playerControllerMock;
    @Mock
    private PlayerService playerServiceMock;
    @Mock
    private NbaTeamService teamServiceMock;
    @Mock
    private PlayerMapper playerMapperMock;

    @Before
    public void setUp(){
        playerDto = new PlayerDto();
        team = new Team();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(playerControllerMock).build();
    }


    @Test
    public void shouldPassGetPlayers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PLAYERS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(playerServiceMock, times(1)).findAll();
    }

    @Test
    public void shouldPassPostPlayers() throws Exception {
        playerDto.setTeamId(TEAM_ID);
        when(teamServiceMock.findById(TEAM_ID)).thenReturn(team);
        when(playerMapperMock.mapPlayerDtoToPlayer(any())).thenReturn(new Player());

        mockMvc.perform(MockMvcRequestBuilders.post(PLAYERS_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .content(asJsonString(playerDto)));

        verify(playerServiceMock, times(1)).createPlayer(any());
        verify(playerMapperMock, times(1)).mapPlayerDtoToPlayer(any());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
