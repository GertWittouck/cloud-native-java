package com.gwi.accountservice.services;

import com.gwi.accountservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.RequestEntity.get;

import java.net.URI;

@Service
public class UserService {

    private final String serviceHost;
    private final RestTemplate restTemplate;

    public UserService(@Value("${user-service.host}") String serviceHost, RestTemplate restTemplate) {
        this.serviceHost = serviceHost;
        this.restTemplate = restTemplate;
    }

    public User getAuthenticatedUser() {
        URI url = URI.create(String.format("http://%s/uua/v1/me", serviceHost));
        RequestEntity<Void> request = get(url).header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE).build();
        return restTemplate.exchange(request, User.class).getBody();
    }
}
