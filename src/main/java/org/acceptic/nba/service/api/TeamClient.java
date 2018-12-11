package org.acceptic.nba.service.api;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource({"classpath:properties/api_config.properties"})
public class TeamClient implements ApiClient {
    @Value("${url}")
    private String URL;
    private static final String USER_AGENT = "User-agent";
    private static final String USER_AGENT_VALUE = "MyRobot/1.0 (email@example.com)";

    public String findAll() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        HttpHeaders headers = new HttpHeaders();
        headers.set(USER_AGENT, USER_AGENT_VALUE);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                URL, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
