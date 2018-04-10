package com.example.demo.sample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part10ReactiveToBlocking {

    User monoToValue(Mono<User> mono) {
        return mono.block();
    }

    Iterable<User> fluxToValues(Flux<User> flux) {
        return flux.toIterable();
    }

}
