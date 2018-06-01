package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {
		Flux<String> flux = Flux.just("red", "white", "blue");

		System.out.println();
	}

	@Test
	public void test2() {
		Flux<String> flux = Flux.just("red", "white", "blue");

		Flux<String> upper = flux
				.log()
				.map(String::toUpperCase);

		System.out.println();
	}

	@Test
	public void test3() {
		Stream<String> stream = Stream.of("red", "white", "blue");

		Stream<String> upper = stream.map(value -> {
			System.out.println(value);
			return value.toUpperCase();
		});

		System.out.println();
	}

	@Test
	public void test4() {
		Flux.just("red", "white", "blue")
				.log()
				.map(String::toUpperCase)
				.subscribe();
	}

	@Test
	public void test5() {
		Flux.just("red", "white", "blue")
				.log()
				.map(String::toUpperCase)
				.subscribe(System.out::println);
	}

	@Test
	public void test6() {
		Flux.just("red", "white", "blue")
				.log()
				.map(String::toUpperCase)
				.subscribe(new Subscriber<String>() {
					@Override
					public void onSubscribe(Subscription s) {
						s.request(Long.MAX_VALUE);
					}
					@Override
					public void onNext(String s) {
						System.out.println(s);
					}
					@Override
					public void onError(Throwable t) {
					}
					@Override
					public void onComplete() {
					}
				});
	}

	public void test7() {
		Flux.just("red", "white", "blue")
			.subscribe(new Subscriber<String>() {
				private long count = 0;
				private Subscription subscription;

				@Override
				public void onSubscribe(Subscription s) {
					this.subscription = s;
					subscription.request(2);
				}
				@Override
				public void onNext(String s) {
					count++;
					if(count>2) {
						count = 0;
						subscription.request(2);
					}
				}
				@Override
				public void onError(Throwable t) {
				}
				@Override
				public void onComplete() {
				}
			});
	}

	public void test8() {

	}

	public void test9() {
//		Flux.just("red", "white", "blue")
//				.log()
//				.map(String::toUpperCase)
//				.subscribeOn(Schedulers.parallel())
//				.subscribe(null, 2);
	}

	public void test10() {
//		Flux.just("red", "white", "blue")
//				.log()
//				.flatMap(value ->
//						Mono.just(value.toUpperCase())
//				.subscribeOn(Schedulers.parallel()),2)
//				.subscribe(value -> {
//					System.out.println("Consumed: " + value);
//				});
	}

}
