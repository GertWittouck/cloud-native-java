package com.gwi.accountservice.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class UserTest {

    private User user;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JacksonTester<User> json;

    @Before
    public void setUp() {
        this.user = new User()
                .setId(0L)
                .setFirstName("Jack")
                .setLastName("Frost")
                .setUsername("user");
    }

    @Test
    public void deserializeJson() throws IOException {
        String content = "{\n" +
                "  \"username\": \"user\",\n" +
                "  \"firstName\": \"Jack\",\n" +
                "  \"lastName\": \"Frost\",\n" +
                "  \"id\": 0\n" +
                "}";

        assertThat(this.json.parse(content)).isEqualTo(
                new User().setFirstName("Jack").setLastName("Frost").setUsername("user").setId(0L)
        );
        assertThat(this.json.parseObject(content).getUsername()).isEqualTo("user");
    }

    @Test
    public void serializeJson() throws IOException {
        assertThat(this.json.write(user)).isEqualTo("user.json");
        assertThat(this.json.write(user)).isEqualToJson("user.json");
        assertThat(this.json.write(user)).hasJsonPathStringValue("@.username");
        assertJsonPropertyEquals("@.username", "user");
        assertJsonPropertyEquals("@.firstName", "Jack");
        assertJsonPropertyEquals("@.lastName", "Frost");
    }

    private void assertJsonPropertyEquals(String key, String value) throws IOException{
        assertThat(this.json.write(user)).extractingJsonPathStringValue(key).isEqualTo(value);
    }
}
