package com.example.demo.controller.rest;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/test")
    public Mono<Post> test() {
        Post post = new Post();
        post.setAuthor("test");
        post.setTitle("testTitle");
        post.setContent("testContent");

        return postService.create(post);
    }

    @GetMapping
    public Flux<Post> findAll() {
        log.debug("findAll Post");
        return postService.findAll();
    }

    @GetMapping("/find")
    public Flux<Post> findByTitle(@RequestParam String postTitle) {
        log.debug("findByTitle Post with postTitle : {}", postTitle);
        return postService.findByTitle(postTitle);
    }

    @GetMapping("/{id}")
    public Mono<Post> findOne(@PathVariable String id) {
        log.debug("findOne Post with id : {}", id);
        return postService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Post> create(@RequestBody Post post) {
        log.debug("create Post with blog : {}", post);
        return postService.create(post);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable String id) {
        log.debug("delete Post with id : {}", id);
        return postService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<Post> updateBlog(@RequestBody Post post, @PathVariable String id) {
        log.debug("update Post with id : {} and post : {}", id, post);
        return postService.update(post, id);
    }

}
