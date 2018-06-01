package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Mono<Post> create(Post post) {
        return Mono.just(postRepository.insert(post).block());
    }

    @Override
    public Mono<Post> update(Post post, String id) {
        return findOne(id).doOnSuccess(findPost -> {
            findPost.setContent(post.getContent());
            findPost.setTitle(post.getTitle());
            findPost.setAuthor(post.getAuthor());
            postRepository.save(findPost).subscribe();
        });
    }

    @Override
    public Flux<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Mono<Post> findOne(String id) {
        return postRepository.findByIdAndDeleteIsFalse(id).
                switchIfEmpty(Mono.error(new Exception("No Post found with Id: "+id)));
    }

    @Override
    public Flux<Post> findByTitle(String title) {
        return postRepository.findByAuthorAndDeleteIsFalse(title).
                switchIfEmpty(Mono.error(new Exception("No Post found with title Containint: "+title)));
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(post -> {
            post.setDelete(true);
            postRepository.save(post).subscribe();
        }).flatMap(post -> Mono.just(Boolean.TRUE));
    }
}
