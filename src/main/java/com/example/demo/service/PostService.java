package com.example.demo.service;

import com.example.demo.domain.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> create(Post post);

    Mono<Post> update(Post post, String id);

    Flux<Post> findAll();

    Mono<Post> findOne(String id);

    Flux<Post> findByTitle(String title);

    Mono<Boolean> delete(String id);

}
