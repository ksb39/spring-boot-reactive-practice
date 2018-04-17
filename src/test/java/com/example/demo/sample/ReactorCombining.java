package com.example.demo.sample;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorCombining {

    @Test
    public void zip() {
        Flux<String> flux1 = Flux.just("hello ");
        Flux<String> flux2 = Flux.just("reactive");
        Flux<String> flux3 = Flux.just(" world");
        Flux.zip(flux1, flux2, flux3)
                .map(tuple3 -> tuple3.getT1().concat(tuple3.getT2()).concat(tuple3.getT3()))
                .map(String::toUpperCase)
                .subscribe(value -> System.out.println("zip result: " + value));
    }

    @Test
    public void merge() {
        Flux<String> flux1 = Flux.just("hello").doOnNext(value -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Flux<String> flux2 = Flux.just("reactive").doOnNext(value -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Flux<String> flux3 = Flux.just("world");
        Flux.merge(flux1, flux2, flux3)
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    public void concat() {
        Flux<String> flux1 = Flux.just("hello");
        Flux<String> flux2 = Flux.just("reactive");
        Flux<String> flux3 = Flux.just("world");
        Flux.concat(flux1, flux2, flux3)
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    public void switchIfEmpty() {
        Flux.empty()
                .switchIfEmpty(Flux.just("Switch flux"))
                .subscribe(System.out::println);
    }

    @Test
    public void switchMap() {
        Flux.just(1, 2, 30, 4, 5)
                .switchMap(value -> {
                    if (value > 10) {
                        return Flux.just(value / 10);
                    }
                    return Flux.just(value);
                })
                .subscribe(System.out::println);
    }

}
