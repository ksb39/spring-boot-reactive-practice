package com.example.demo.controller;

import com.example.demo.sample.ExampleService;
import com.example.demo.sample.Sir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("hello/{who}")
    public Mono<String> hello(@PathVariable String who) {
        return Mono.just(who)
                .map(w -> "Hello " + w + "!");
    }

    @GetMapping("helloDelay/{who}")
    public Mono<String> helloDelay(@PathVariable String who) {
        return exampleService.withDelay("Hello " + who + "!!", 2);
    }

    @PostMapping("heyMister")
    public Flux<String> hey(@RequestBody Mono<Sir> body) {
//        return Mono.just("Hey mister ")
//                .concatWith(body
//                .flatMap(sir -> Flux.fromArray(sir.getLastname().split("")))
//                .map(String::toUpperCase)
//                .take(1)
//                ).concatWith(Mono.just(". how are you?"));
        return null;
    }

}
