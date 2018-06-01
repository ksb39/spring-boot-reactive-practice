package com.example.demo.repository;

import com.example.demo.domain.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {

    Flux<Post> findByAuthor(String author);

    Flux<Post> findByAuthorAndDeleteIsFalse(String titleKeyword);

    Mono<Post> findByTitle(String title);

    Mono<Post> findByIdAndDeleteIsFalse(String id);

}
