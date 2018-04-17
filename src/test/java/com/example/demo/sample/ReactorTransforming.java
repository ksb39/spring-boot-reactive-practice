package com.example.demo.sample;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class ReactorTransforming {

    @Test
    public void flatMap() {
        Flux.just("hello")
                .flatMap(value -> Flux.just("flatMap")
                        .map(newValue -> value.concat(" ").concat(newValue))
                        .flatMap(lastValue -> Flux.just("operator")
                                .map(newValue -> lastValue.concat(" ").concat(newValue))))
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }


    @Test
    public void scan() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .scan(new ArrayList<Integer>(), (list, newValue) -> {
                    list.add(newValue);
                    return list;
                })
                .subscribe(System.out::println);
    }

    @Test
    public void compose() throws InterruptedException {
        Flux.just(1, 2, 3, 4, 5)
                .compose(Flux::collectList)
                .doOnNext(value -> System.out.println("Thread:" + Thread.currentThread().getName()))
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    @Test
    public void flatMapVsCompose() throws InterruptedException {
        Flux.just(1, 2, 3, 4, 5)
                .flatMap(Flux::just)
                .doOnNext(value -> System.out.println("Thread:" + Thread.currentThread().getName()))
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    @Test
    public void window() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .window(5)
                .flatMap(flux -> {
                    System.out.println("New Flux:" + flux);
                    return flux;
                })
                .subscribe(System.out::println);
    }

}
