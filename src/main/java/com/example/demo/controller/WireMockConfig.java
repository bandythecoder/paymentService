package com.example.demo.controller;


import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;


@Configuration
public class WireMockConfig {

    // Bean to set up the WireMock server
    @Bean
    public CommandLineRunner wireMockServer() {
        return args -> {
            // Configure WireMock to run on port 8080
            WireMock.configureFor("localhost", 8080);

            // Start WireMock server
            WireMock.start();

            // Set up stub mappings
            WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/payment"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{ \"status\": \"success\", \"message\": \"Payment processed successfully\" }")));

            // You can add more mocks here for other endpoints as needed
            WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/api/payment"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(201)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{ \"status\": \"created\", \"message\": \"Payment added successfully\" }")));

            // Optionally, log the WireMock server status
            System.out.println("WireMock server started on http://localhost:8080");
        };
    }

    // Optionally, provide a bean to stop WireMock when the application shuts down
    @Bean
    public CommandLineRunner stopWireMockServer() {
        return args -> {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                WireMock.stop();
                System.out.println("WireMock server stopped.");
            }));
        };
    }
}
