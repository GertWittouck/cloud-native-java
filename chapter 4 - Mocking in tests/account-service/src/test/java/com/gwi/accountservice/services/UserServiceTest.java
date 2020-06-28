package com.gwi.accountservice.services;

import com.gwi.accountservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(
        value = {UserService.class},
        properties = {
                "spring.cloud.config.enabled=false",
                "user-service.host=localhost:8083",
                "server.port=8083"})
@AutoConfigureWebClient(registerRestTemplate = true)
public class UserServiceTest {

    @Value("${user-service.host}")
    private String serviceHost;

    @Autowired
    private UserService userService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getAuthenticatedUserShouldReturnUser() {

        this.server
                .expect(requestTo(String.format("http://%s/uua/v1/me", serviceHost)))
                .andRespond(withSuccess(new ClassPathResource("/com/gwi/accountservice/model/user.json", getClass()), MediaType.APPLICATION_JSON));

        User user = userService.getAuthenticatedUser();

        assertThat(user.getId()).isEqualTo(0);
        assertThat(user.getUsername()).isEqualTo("user");
        assertThat(user.getFirstName()).isEqualTo("Jack");
        assertThat(user.getLastName()).isEqualTo("Frost");
    }
}
