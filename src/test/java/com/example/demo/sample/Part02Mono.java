package com.example.demo.sample;

import reactor.core.publisher.Mono;

public class Part02Mono {

    Mono<String> emptyMono() {
        return Mono.empty();
    }

    Mono<String> monoWithNoSignal() {
        return Mono.never();
    }

    Mono<String> fooMono() {
        return Mono.just("foo");
    }

    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }

}
