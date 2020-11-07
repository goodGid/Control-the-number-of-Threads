package dev.be.goodgid.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReconcileControllerTest {

    /**
     * WebTestClient를 사용하기 위해서는
     * implementation 'org.springframework.boot:spring-boot-starter-webflux' 선언이 필요하다.
     * ref : https://goodgid.github.io/Spring-Test-SpringBootTest-Annotation/#webenvironmentrandom_port--webtestclient
     */
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void reconcile(){
        webTestClient.get().uri("/reconcile")
                     .exchange()
                     .expectStatus().isOk();
    }

}