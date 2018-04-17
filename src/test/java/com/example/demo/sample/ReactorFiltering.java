package com.example.demo.sample;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorFiltering {

    @Test
    public void filter() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(value -> value < 6)
                .subscribe(System.out::println);
    }

    @Test
    public void distinct() {
        Flux.just(1, 2, 3, 4, 5, 8, 6, 7, 8, 2, 5, 1, 3, 6, 8, 10, 9, 10)
                .distinct()
                .subscribe(System.out::println);
    }

    @Test
    public void take() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .take(5)
                .subscribe(System.out::println);
    }

    @Test
    public void last() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .last()
                .subscribe(System.out::println);
    }

    @Test
    public void skip() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .skip(5)
                .subscribe(System.out::println);
    }

}
