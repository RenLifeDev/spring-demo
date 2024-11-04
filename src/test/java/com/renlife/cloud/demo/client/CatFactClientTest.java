package com.renlife.cloud.demo.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renlife.cloud.demo.client.dto.CatFactResponseDto;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CatFactClientTest {

    static MockWebServer mockWebServer;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void afterAll() throws Exception {
        mockWebServer.shutdown();
    }

    CatFactClient client;

    @BeforeEach
    void beforeEach() {
        var webClient = WebClient.builder()
                .baseUrl(String.format("http://localhost:%s", mockWebServer.getPort()))
                .build();

        client = new CatFactClient(webClient);
    }

    @Test // TODO должен написать что то такое
    void test() throws InterruptedException, JsonProcessingException {
        var dto = new CatFactResponseDto()
                .setFact("Fact");

        mockWebServer.enqueue(new MockResponse()
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(objectMapper.writeValueAsString(dto))
        );

        // When
        var fact = client.getFact();

        // Then
        var request = mockWebServer.takeRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(objectMapper.writeValueAsString(fact)).isEqualTo("{\"fact\":\"Fact\"}");
    }
}