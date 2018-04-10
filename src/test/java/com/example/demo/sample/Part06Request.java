package com.example.demo.sample;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Part06Request {

    StepVerifier requestAllExpectFour(Flux<User> flux) {
        return StepVerifier.create(flux).thenRequest(Long.MAX_VALUE).expectNextCount(4).expectComplete();
    }

    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux).thenRequest(1).
                expectNext(User.SKYLER).thenRequest(1).expectNext(User.JESSE).thenCancel();
    }

}
