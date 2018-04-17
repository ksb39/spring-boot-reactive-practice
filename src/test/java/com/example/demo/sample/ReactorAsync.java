package com.example.demo.sample;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactorAsync {

    @Test
    public void subscribeOn() throws InterruptedException {
        Scheduler scheduler = Schedulers.newElastic("thread");
        Scheduler scheduler1 = Schedulers.newElastic("thread");
        Scheduler scheduler2 = Schedulers.newElastic("thread");

        Flux<String> flux1 = Flux.just("hello")
                .doOnNext(value -> System.out.println("Value " + value + " on :" + Thread.currentThread().getName()))
                .subscribeOn(scheduler);

        Flux<String> flux2 = Flux.just("reactive")
                .doOnNext(value -> System.out.println("Value " + value + " on :" + Thread.currentThread().getName()))
                .subscribeOn(scheduler1);

        Flux<String> flux3 = Flux.just("world")
                .doOnNext(value -> System.out.println("Value " + value + " on :" + Thread.currentThread().getName()))
                .subscribeOn(scheduler2);

        Flux.zip(flux1, flux2, flux3)
                .map(tuple3 -> tuple3.getT1().concat(tuple3.getT2()).concat(tuple3.getT3()))
                .map(String::toUpperCase)
                .subscribe(value -> System.out.println("zip result:" + value));
        Thread.sleep(1000);
    }

    @Test
    public void publishOn() throws InterruptedException {
        Scheduler scheduler = Schedulers.newElastic("thread");
        Flux.just("Hello", "async", "world")
                .doOnNext(value -> System.out.println("current thread:" + Thread.currentThread().getName()))
                .publishOn(scheduler)
                .doOnNext(value -> System.out.println("after publishOn thread:" + Thread.currentThread().getName()))
                .subscribe();
    }

}
