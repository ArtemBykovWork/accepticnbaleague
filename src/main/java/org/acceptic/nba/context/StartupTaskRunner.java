package org.acceptic.nba.context;

import org.acceptic.nba.service.parse.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupTaskRunner {
    @Autowired
    private ParserService parserService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        parserService.collectAllTeams();
    }
}