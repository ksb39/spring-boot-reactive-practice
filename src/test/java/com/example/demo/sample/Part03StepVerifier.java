package com.example.demo.sample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

public class Part03StepVerifier {

    void expectFooBarComplete(Flux<String> flux) {
        StepVerifier.create(flux).expectNext("foo", "bar").verifyComplete();
    }

    void expectFootBarError(Flux<String> flux) {
        StepVerifier.create(flux).expectNext("foo", "bar").expectError(RuntimeException.class);
    }

    void expectSkylerJesseComplete(Flux<User> flux) {
        StepVerifier.create(flux)
                .expectNextMatches(u -> "swhite".equals(u.getUsername()))
                .expectNextMatches(u -> "jpinkman".equals(u.getUsername()))
                .verifyComplete();
    }

    void expect10Element(Flux<Long> flux) {
        StepVerifier.create(flux).expectNextCount(10).verifyComplete();
    }

    void expect3600Elements(Supplier<Flux<Long>> supplier) {
        StepVerifier.withVirtualTime(supplier).thenAwait(Duration.ofHours(3)).
                expectNextCount(3600).verifyComplete();
    }

    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(u ->
            new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase())
        );
    }

    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(
                u -> new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase())
        );
    }

    Flux<User> asyncCapitalizeUser(User u) {
        return Flux.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
    }

    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(u -> asyncCapitalizeUser(u));
    }

    Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
        return flux1.mergeWith(flux2);
    }

    Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
        return flux1.concatWith(flux2);
    }

    Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
        return Flux.concat(mono1, mono2);
    }

}
