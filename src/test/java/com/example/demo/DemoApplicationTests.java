package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void homeEndpointWorks() {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(response).isEqualTo("Hello, World! Your Spring Boot application is running successfully!");
	}

	@Test
	void helloEndpointWorks() {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
		assertThat(response).isEqualTo("Hello from Spring Boot!");
	}
}