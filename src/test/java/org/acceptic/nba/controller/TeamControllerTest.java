package org.acceptic.nba.controller;

import org.acceptic.nba.mapping.PlayerMapper;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {
    private static final String TEAMS_URL = "/teams";
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private TeamController teamController;
    @Mock
    private NbaTeamService teamServiceMock;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
    }

    @Test
    public void shouldPassGetPlayers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEAMS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(teamServiceMock, times(1)).findAll();
    }


}
