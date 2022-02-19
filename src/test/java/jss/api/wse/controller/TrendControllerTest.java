package jss.api.wse.controller;

import jss.api.wse.model.Trend;
import jss.api.wse.service.TrendService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = TrendController.class)
final class TrendControllerTest {

    @MockBean
    TrendService service;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void itShouldCreate() {
        final Trend trend = new Trend("MTO", "Motorola", LocalDateTime.now());

        Mockito.when(service.create(trend)).thenReturn(Mono.just(trend));

        webTestClient.post()
                .uri("/trends")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(trend))
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("code").isEqualTo("MTO")
                .jsonPath("name").isEqualTo("Motorola")
                .jsonPath("createdAt").isNotEmpty();


        Mockito.verify(service, Mockito.times(1)).create(trend);
    }

    @Test
    void itShouldNotCreate() {
        final Trend trend = new Trend("MTO", "Motorola", LocalDateTime.now());

        Mockito.when(service.create(trend)).thenThrow(new RuntimeException());

        webTestClient.post()
                .uri("/trends")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(trend))
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
