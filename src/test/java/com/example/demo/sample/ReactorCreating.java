package com.example.demo.sample;

import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class ReactorCreating {

    @Test
    public void just() {
        Disposable subscribe = Flux.just("hello", "reactive", "String", "world", "?")
                .filter(value -> value.length() > 1)
                .map(String::toUpperCase)
                .subscribe(value -> System.out.println("On next callback: " + value),
                        t -> System.out.println("On error callback: " + t),
                        () -> System.out.println("On complete callback"));

        System.out.println("It disposable:" + subscribe.isDisposed());
    }

    @Test
    public void justError() {
        Flux.just("hello", "reactive", "Spring", null, "?")
                .filter(value -> value.length() > 1)
                .subscribe(value -> System.out.println("On next callback: " + value),
                        t -> System.out.println("On error callback: " + t),
                        () -> System.out.println("On complete callback"));
    }

    @Test
    public void from() {
        Flux<String> flux = Flux.just("hello", "reactive", "Spring", "world", "?")
                .filter(value -> value.length() >1);
        Flux.from(flux)
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    public void interval() throws InterruptedException {
        Disposable subscribe = Flux.interval(Duration.of(1, ChronoUnit.SECONDS))
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    return value * 10;
                })
                .subscribe(value -> System.out.println("Interval value: " + value));
        System.out.println("It disposable:" + subscribe.isDisposed());
    }

    private String value = "Hello";

    @Test
    public void defer() {
        Flux<String> flux = Flux.defer(() -> Flux.just(value));
        value = "Hello reactive world";
        flux.subscribe(value -> System.out.println("Item with updated value:" + value));
    }

    @Test
    public void fromStream() {
        Stream<String> stream = Arrays.asList("hello", "reactive", "reactive", "spring", "world").stream()
                .map(String::toUpperCase)
                .distinct();
        Flux.fromStream(stream)
                .doOnNext(value -> System.out.println("Stream value:" + value))
                .subscribe();
    }

    @Test
    public void fromIterable() {
        Flux.fromIterable(Arrays.asList("hello", "old", "rx", "world"))
                .map(value -> value.replace("old", "reactive"))
                .map(value -> value.replace("rx", "spring"))
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    public void first() {
        Flux.first(Flux.just(1), Flux.just(3), Flux.just(4), Flux.just(5))
                .subscribe(System.out::println);
    }

    @Test
    public void range() {
        Flux.range(1, 10)
                .subscribe(System.out::println);
    }

    LinkedBlockingQueue<String> users = new LinkedBlockingQueue<>();

    @Test
    public void testBroadcase() {

    }

    private void broadcast(String user) {
        users.add(user);
        Flux.fromIterable(users)
                .filter(otherUsers -> !user.equals(otherUsers))
                .doOnNext(otherUser -> System.out.println("Here we can inform other users"))
                .subscribe(value -> System.out.println("On next callback: " + value),
                        t -> System.out.println("On error callback: " + t),
                        () -> System.out.println("On complete callback"));
    }

    int count = 0;

    @Test
    public void checkIfItDisposable() throws InterruptedException {
        Disposable subscribe = Flux.just(1,2,3,4,5,6,7,8,9,10)
                .map(number -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return number;
                }).subscribeOn(Schedulers.newElastic("1"))
                .subscribe();

        while (!subscribe.isDisposed() && count < 100) {
            Thread.sleep(400);
            count++;
            System.out.println("Waiting.....");
        }
        System.out.println("It disposable: " + subscribe.isDisposed());
    }

    @Test
    public void checkIfItDisposableBlocking() {
        Flux.just(1,2,3,4,5,6,7,8,9,10)
                .map(number -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return number;
                }).subscribeOn(Schedulers.newElastic("1"))
                .blockLast(Duration.of(60, ChronoUnit.SECONDS));
        System.out.println("It disposable");
    }

}
