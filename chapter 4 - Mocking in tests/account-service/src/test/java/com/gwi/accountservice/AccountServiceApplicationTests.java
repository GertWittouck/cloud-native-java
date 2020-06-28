package com.gwi.accountservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.cloud.config.enabled=false", "user-service.host=localhost:8083"})
class AccountServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
