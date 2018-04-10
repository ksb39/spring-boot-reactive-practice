package com.example.demo.sample;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

public class Part01Flux {

    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(new ArrayList<>(Arrays.asList("foo", "bar")));
    }

    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

}
